package com.osmochilas.creditCardPointManager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="creditCards")
@Data
public class CreditCardEntity {
    @Id
    private Long id;
    private String userId;
    private String bankId;
    private String bankName;
    private String creditCardId;
    private String creditCardName;
    private Double points;
    private String currency;
}
