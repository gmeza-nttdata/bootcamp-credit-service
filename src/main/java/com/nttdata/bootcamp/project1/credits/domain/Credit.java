package com.nttdata.bootcamp.project1.credits.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class Credit {
    private String number;
    private Integer userId;
    private Type userType;
    private CreditType creditType;
    private String currencyName;
    private BigDecimal balance;

    private BigDecimal creditLine;
    private LocalDate expiration;
}
