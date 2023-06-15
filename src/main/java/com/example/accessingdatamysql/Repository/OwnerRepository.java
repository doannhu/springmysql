package com.example.accessingdatamysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accessingdatamysql.Entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    
}
