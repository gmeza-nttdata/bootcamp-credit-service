package com.nttdata.bootcamp.creditservice.application;

import com.nttdata.bootcamp.creditservice.domain.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditOperations {
    Flux<Credit> queryAll();
    Mono<Credit> findById(String id);
    Mono<Credit> create(Credit credit);
    Mono<Credit> update(String id,Mono<Credit> credit);
    Mono <Void> delete(String id);
}
