package com.osmochilas.creditCardPointManager.controller;

import com.osmochilas.creditCardPointManager.domain.CreditCard;
import com.osmochilas.creditCardPointManager.service.CreditCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/credit-cards/users/{userId}")
    public ResponseEntity<List<CreditCard>> getCreditCards(
            @PathVariable String userId) {
        return ResponseEntity.ok(creditCardService.getCreditCards(userId));
    }
}
