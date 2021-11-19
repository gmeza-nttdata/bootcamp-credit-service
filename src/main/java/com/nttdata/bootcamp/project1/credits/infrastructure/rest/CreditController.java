package com.nttdata.bootcamp.project1.credits.infrastructure.rest;

import com.nttdata.bootcamp.project1.credits.application.CreditOperations;
import com.nttdata.bootcamp.project1.credits.application.impl.CreditOperationImpl;
import com.nttdata.bootcamp.project1.credits.domain.Credit;

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
        return Flux.fromIterable(creditOperation.queryAll());
    }

    @GetMapping("/{id}")
    public Mono<Credit> getCreditId(@PathVariable int id){
        return Mono.justOrEmpty(creditOperation.findCreditId(id));
    }

    @PostMapping()
    public Mono<Credit> post (@RequestBody Credit credit){
        return Mono.justOrEmpty(creditOperation.create(credit));
    }

    @PutMapping()
    public Mono<Credit> put(@PathVariable int id, @RequestBody Credit credit){
        return Mono.justOrEmpty(creditOperation.update(id, credit));
    }

    @DeleteMapping()
    public void delete(@PathVariable int id){
        creditOperation.delete(id);
    }
    
}
