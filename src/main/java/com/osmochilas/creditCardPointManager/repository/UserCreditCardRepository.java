package com.osmochilas.creditCardPointManager.repository;

import com.osmochilas.creditCardPointManager.entity.UserCreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCreditCardRepository extends JpaRepository<UserCreditCardEntity, String> {
}
