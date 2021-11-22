package com.nttdata.bootcamp.project1.credits.application.model;

import java.util.List;

import com.nttdata.bootcamp.project1.credits.domain.Credit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditRepository {
    Mono <Credit> getCreditId(String id);
    Flux <Credit> getAll();
    Mono <Credit> save(Credit credit);
    Mono<Void> delete(String id);
    Mono<Credit> update(Mono<Credit> credit, String id);

}
