package com.nttdata.bootcamp.creditservice.infrastructure.rest;

import com.nttdata.bootcamp.creditservice.application.CreditOperations;
import com.nttdata.bootcamp.creditservice.domain.Credit;

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


@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {
  
    private final CreditOperations creditOperation;

    @GetMapping
    public Flux<Credit> get(){
        return creditOperation.queryAll();
    }

    @GetMapping("/{id}")
    public Mono<Credit> getCreditId(@PathVariable String id){
        return creditOperation.findCreditId(id);
    }

    @PostMapping()
    public Mono<Credit> post (@RequestBody Credit credit){
        return creditOperation.create(credit);
    }

    @PutMapping("/{id}")
    public Mono<Credit> put(@PathVariable String id, @RequestBody Mono<Credit> credit){
        return creditOperation.update(id, credit);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return creditOperation.delete(id);
    }
    
}
