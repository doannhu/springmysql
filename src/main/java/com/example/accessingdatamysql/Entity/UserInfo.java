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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String roles;

    @OneToMany(targetEntity = Room.class, cascade = CascadeType.ALL)
    @JoinColumn(name="linkToRoom")
    private List<Room> rooms;

    @OneToMany(targetEntity = Renting.class, cascade = CascadeType.ALL)
    @JoinColumn(name="rentingContract")
    private List<Renting> rentingList;
    
}   
