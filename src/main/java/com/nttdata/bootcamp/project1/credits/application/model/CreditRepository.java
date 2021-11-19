package com.nttdata.bootcamp.project1.credits.application.model;

import java.util.List;

import com.nttdata.bootcamp.project1.credits.domain.Credit;

public interface CreditRepository {
    Credit getCreditId(int id);
    List<Credit> getAll();
}
