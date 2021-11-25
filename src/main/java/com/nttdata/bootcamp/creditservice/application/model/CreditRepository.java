package com.nttdata.bootcamp.creditservice.application.model;

import com.nttdata.bootcamp.creditservice.domain.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditRepository {
    Mono <Credit> getCreditId(String id);
    Flux <Credit> getAll();
    Mono <Credit> save(Credit credit);
    Mono<Void> delete(String id);
    Mono<Credit> update(Mono<Credit> credit, String id);

}
