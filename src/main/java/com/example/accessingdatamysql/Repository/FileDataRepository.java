package com.example.accessingdatamysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accessingdatamysql.Entity.FileData;

public interface FileDataRepository extends JpaRepository<FileData, Integer> {
    
}
