package com.nttdata.bootcamp.creditservice.infrastructure.model.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.nttdata.bootcamp.creditservice.domain.CreditType;
import com.nttdata.bootcamp.creditservice.domain.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("credit")
public class CreditDao {
    @Id
    private String number;
    private Integer userId;
    private Type userType;
    private CreditType creditType;
    private String currencyName;
    private BigDecimal balance;

    private BigDecimal creditLine;
    private LocalDate expiration;
}
