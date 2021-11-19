package com.nttdata.bootcamp.project1.credits.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Credit {
    private int id;
    private Date expirationDate;
    private String cardType;
}
