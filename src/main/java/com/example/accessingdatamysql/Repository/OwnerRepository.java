package com.example.accessingdatamysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accessingdatamysql.Entity.Owner;

import java.util.Optional;


public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Optional<Owner> findByName(String username);
}
