package com.nttdata.bootcamp.creditservice.infrastructure.repository;

import com.nttdata.bootcamp.creditservice.application.model.CreditRepository;
import com.nttdata.bootcamp.creditservice.domain.Credit;
import com.nttdata.bootcamp.creditservice.infrastructure.model.dao.CreditDao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CreditCrudRepository implements CreditRepository {
    @Autowired
    ICreditCrudRepository repository;

    @Override
    public Mono<Credit> getCreditId(String id) {
        return repository.findById(id)
                .map(this::mapCreditDaoToCredit);
    }

    @Override
    public Flux<Credit> getAll() {
        return repository.findAll()
                .map(this::mapCreditDaoToCredit);
    }
    

    private CreditDao mapCreditToCreditDao(Credit credit){
        CreditDao creditDao=new CreditDao();
        BeanUtils.copyProperties(credit, creditDao);
        return creditDao;
    }

    private Credit mapCreditDaoToCredit(CreditDao creditDao){
        Credit credit=new Credit();
        BeanUtils.copyProperties(creditDao, credit);
        return credit;
    }
    @Override
    public Mono<Credit> save(Credit credit) {
        return repository.save(mapCreditToCreditDao(credit))
                .map(this::mapCreditDaoToCredit);
    }

    @Override
    public Mono<Credit> update(Mono<Credit> credit, String id) {
        return repository.findById(id)
                .flatMap(c->credit.map(this::mapCreditToCreditDao)
                .doOnNext(i->i.setNumber(id)))
                .flatMap(repository::save)
                .map(this::mapCreditDaoToCredit);

        /*return repository.update(mapCreditToCreditDao(credit))
                .map(this::mapCreditDaoToCredit);*/
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }


}
