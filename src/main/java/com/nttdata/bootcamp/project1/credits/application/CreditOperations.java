package com.nttdata.bootcamp.project1.credits.application;

import java.util.List;

import com.nttdata.bootcamp.project1.credits.domain.Credit;

public interface CreditOperations {
    List<Credit> queryAll();
    Credit findCreditId(int id);
    Credit create(Credit credit);
    Credit update(int id,Credit credit);
    void delete(int id);
    void publicCredit(Credit credit);
}
