package com.example.accessingdatamysql.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany(targetEntity = Renting.class, cascade = CascadeType.ALL)
    @JoinColumn(name="rentingRoom")
    private List<Renting> rentingList;

}
