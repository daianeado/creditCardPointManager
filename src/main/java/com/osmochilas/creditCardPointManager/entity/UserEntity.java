package com.osmochilas.creditCardPointManager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name="users")
@Data
public class UserEntity {

    @Id
    private String cpf;
    private LocalDateTime createdAt;

}
