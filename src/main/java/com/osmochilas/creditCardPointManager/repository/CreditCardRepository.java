package com.osmochilas.creditCardPointManager.repository;

import com.osmochilas.creditCardPointManager.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, String> {
    Optional<List<CreditCardEntity>> findByCpf(String userId);
}
