package com.osmochilas.creditCardPointManager.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class User {

    private String cpf;
    private LocalDateTime createdAt;

}
