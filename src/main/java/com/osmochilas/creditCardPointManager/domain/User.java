package com.osmochilas.creditCardPointManager.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    private String cpf;
    private LocalDate createdAt;
    private List<CreditCard> creditCards;
}
