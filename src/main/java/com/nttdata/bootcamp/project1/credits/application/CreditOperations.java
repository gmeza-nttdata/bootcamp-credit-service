package com.nttdata.bootcamp.project1.credits.application;

import java.util.List;

import com.nttdata.bootcamp.project1.credits.domain.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditOperations {
    Flux<Credit> queryAll();
    Mono<Credit> findCreditId(String id);
    Mono<Credit> create(Credit credit);
    Mono<Credit> update(String id,Mono<Credit> credit);
    Mono <Void> delete(String id);
}
