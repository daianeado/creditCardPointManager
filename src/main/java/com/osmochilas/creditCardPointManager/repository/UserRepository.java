package com.osmochilas.creditCardPointManager.repository;

import com.osmochilas.creditCardPointManager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByCpf(String cpf);
}
