package com.nttdata.bootcamp.creditservice.infrastructure.model.dao;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("credit")
public class CreditDao {
    @Id
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
