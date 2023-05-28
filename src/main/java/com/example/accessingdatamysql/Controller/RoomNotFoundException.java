package com.example.accessingdatamysql.Controller;

public class RoomNotFoundException extends RuntimeException {
    RoomNotFoundException(Integer id) {
        super("Could not find room " + id);
    }
}
