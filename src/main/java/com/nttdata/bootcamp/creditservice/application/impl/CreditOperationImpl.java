package com.nttdata.bootcamp.creditservice.application.impl;

import com.nttdata.bootcamp.creditservice.application.model.CreditRepository;
import com.nttdata.bootcamp.creditservice.application.CreditOperations;
import com.nttdata.bootcamp.creditservice.domain.Credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditOperationImpl implements CreditOperations{
    @Autowired
    CreditRepository repository;

    @Override
    public Flux<Credit> queryAll() {
        return repository.getAll();
    }

    @Override
    public Mono<Credit> findById(String id) {
        return repository.getCreditId(id);
    }

    @Override
    public Mono<Credit> create(Credit credit) {
        return repository.save(credit);
    }

    @Override
    public Mono<Credit> update(String id, Mono<Credit> credit) {
        return repository.update(credit, id);
    }

    @Override
    public Mono<Void> delete(String id) {
       return repository.delete(id);
    }

}
