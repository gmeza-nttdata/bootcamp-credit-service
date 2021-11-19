package com.nttdata.bootcamp.project1.credits.application.impl;

import java.util.List;

import com.nttdata.bootcamp.project1.credits.application.CreditOperations;
import com.nttdata.bootcamp.project1.credits.application.model.CreditRepository;
import com.nttdata.bootcamp.project1.credits.domain.Credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditOperationImpl implements CreditOperations{
    @Autowired
    CreditRepository repository;

    @Override
    public List<Credit> queryAll() {
        return repository.getAll();
    }

    @Override
    public Credit findCreditId(int id) {
        return repository.getCreditId(id);
    }

    @Override
    public Credit create(Credit credit) {
        return null;
    }

    @Override
    public Credit update(int id, Credit credit) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void publicCredit(Credit credit) {

    }
    
}
