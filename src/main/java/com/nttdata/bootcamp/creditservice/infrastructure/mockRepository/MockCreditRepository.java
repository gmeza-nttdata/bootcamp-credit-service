package com.nttdata.bootcamp.creditservice.infrastructure.mockRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.nttdata.bootcamp.creditservice.application.model.CreditRepository;
import com.nttdata.bootcamp.creditservice.domain.Credit;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MockCreditRepository implements CreditRepository{

    @Override
    public Mono<Credit> getCreditId(String id) {
        Credit credit=new Credit();
        credit.setNumber("123456");
        credit.setCurrencyName("PE");
        return Mono.just(credit);
    }

    @Override
    public Flux<Credit> getAll() {
        List<Credit> credits=new ArrayList<>();
        return Flux.fromIterable(credits);
    }

    @Override
    public Mono<Credit> save(Credit credit) {
        return Mono.just(credit);
    }


    @Override
    public Mono<Void> delete(String id) {
        return null;
    }

    @Override
    public Mono<Credit> update(Mono<Credit> credit, String id) {
        return null;
    }
    
    
}
