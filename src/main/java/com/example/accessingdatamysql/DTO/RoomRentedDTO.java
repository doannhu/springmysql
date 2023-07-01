package com.example.accessingdatamysql.DTO;



public record RoomRentedDTO (
     Integer id,
     String title,
     String description,
     Float price,
     Float area,
     Float rating,
     Integer capacity,
     Boolean isRented,
     Boolean isAvailable,
     String tenant
) {}
