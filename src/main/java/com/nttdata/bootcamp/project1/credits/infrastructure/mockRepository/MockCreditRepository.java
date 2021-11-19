package com.nttdata.bootcamp.project1.credits.infrastructure.mockRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nttdata.bootcamp.project1.credits.application.model.CreditRepository;
import com.nttdata.bootcamp.project1.credits.domain.Credit;

import org.springframework.stereotype.Component;

@Component
public class MockCreditRepository implements CreditRepository{

    @Override
    public Credit getCreditId(int id) {
        Date expDate=new Date();

        Credit credit=new Credit();
        credit.setId(123456);
        credit.setCardType("Personal");
        credit.setExpirationDate(expDate);
        return credit;
    }

    @Override
    public List<Credit> getAll() {
        List<Credit> credits=new ArrayList<>();
        return credits;
    }
    
}
