package com.example.accessingdatamysql.DTO;


public record RoomDTO(
    Integer id,
    String title,
    String description,
    Float price,
    Float area,
    Float rating,
    Integer capacity
) {


}
