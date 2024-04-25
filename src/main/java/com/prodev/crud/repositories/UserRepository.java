package com.prodev.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodev.crud.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
  Boolean existsByEmail(String email);
}
