package com.osmochilas.creditCardPointManager.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="bills")
@Data
public class BillEntity {

    @Id
    @GeneratedValue
    @Column(name="billid")
    private Integer billId;

    @Column(name="bankid")
    private String bankId;

    @Column(name="bankname")
    private String bankName;

    @Column(name="creditcardid")
    private String creditCardId;

    @Column(name="creditcardname")
    private String creditCardName;

    @Column(name="duedate")
    private LocalDate dueDate;

    @Column(name="totalamount")
    private Double totalAmount;

    @Column(name="currency")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "creditcardid", insertable = false, updatable = false)
    private CreditCardEntity creditCard;
}
