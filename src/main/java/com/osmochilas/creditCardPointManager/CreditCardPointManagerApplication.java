package com.osmochilas.creditCardPointManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CreditCardPointManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditCardPointManagerApplication.class, args);
    }

}
