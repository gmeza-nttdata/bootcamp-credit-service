package com.nttdata.bootcamp.creditservice.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Credit {
    private String number;
    private Integer userId;
    private Boolean hasCard;
    private String currencyName;
    private BigDecimal balance;

    private BigDecimal creditLine;
    private BigDecimal rate;
    private Integer cutoffDate;
    private Integer paymentDate;

}
