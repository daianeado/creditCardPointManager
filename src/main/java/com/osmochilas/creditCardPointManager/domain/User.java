package com.osmochilas.creditCardPointManager.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String cpf;
    private LocalDateTime createdAt;
}
