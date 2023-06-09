package com.example.accessingdatamysql.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity // This tells Hibernate to make a table out of this class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String title;
    private String description;
    private Float price;
    private Float area;
    private Float rating;
    private Integer capacity;
    private Boolean isRented;
    private Boolean isAvailable;

}
