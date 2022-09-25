package com.osmochilas.creditCardPointManager.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name="creditcards")
@Data
public class CreditCardEntity {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="bankid")
    private String bankId;

    @Column(name="bankname")
    private String bankName;

    @Column(name="creditcardid")
    private String creditCardId;

    @Column(name="creditcardname")
    private String creditCardName;

    @Column(name="pointsrule")
    private Double pointsRule;

    @Column(name="currency")
    private String currency;

    @Column(name="cpf")
    private String cpf;

    @OneToMany
    @JoinColumn(name = "billid", insertable = false, updatable = false)
    private List<BillEntity> bills;

    @Transient
    @ManyToOne
    @JoinColumn(name = "creditCards", insertable = false, updatable = false)
    private UserEntity user;
}