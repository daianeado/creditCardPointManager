package com.osmochilas.creditCardPointManager.repository;

import com.osmochilas.creditCardPointManager.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, String> {
    Optional<List<BillEntity>> findByCreditCardId(String creditCardId);
}
