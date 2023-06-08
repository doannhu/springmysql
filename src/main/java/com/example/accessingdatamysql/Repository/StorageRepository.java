package com.example.accessingdatamysql.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accessingdatamysql.Entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData, Integer> {
    
    Optional<ImageData> findByName(String fileName);
}
