package com.osmochilas.creditCardPointManager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="userCreditCards")
@Data
public class UserCreditCardEntity {
    @Id
    private String cpf;
    private String creditCardId;
}
