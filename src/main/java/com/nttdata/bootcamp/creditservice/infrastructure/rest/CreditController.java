package com.nttdata.bootcamp.creditservice.infrastructure.rest;

import com.nttdata.bootcamp.creditservice.application.CreditOperations;
import com.nttdata.bootcamp.creditservice.domain.Credit;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;


@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {
  
    private final CreditOperations operations;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Flux<Credit>>> get(){
        return Mono.just(ResponseEntity.ok(operations.queryAll()));
    }

    @GetMapping(value = "/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Credit>> getCreditId(@PathVariable String number){
        return Mono.just(number)
                .flatMap(operations::findById)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Credit>> post (@RequestBody Credit credit){
        return Mono.just(credit)
                .doOnNext(e -> e.setNumber(null))
                .flatMap(operations::create)
                .map(this::postResponse);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Credit>> put(@PathVariable String id, @RequestBody Mono<Credit> credit){
        return operations.findById(id)
                .flatMap(u-> operations.update(id, credit))
                .map(this::postResponse)
                .defaultIfEmpty(ResponseEntity.notFound().build())
                .onErrorReturn(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return operations.findById(id)
                .flatMap(credit -> operations.delete(credit.getNumber())
                        .thenReturn(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    private ResponseEntity<Credit> postResponse(Credit credit) {
        return ResponseEntity.created(URI.create("/credits/" + credit.getNumber())).body(credit);
    }

}
