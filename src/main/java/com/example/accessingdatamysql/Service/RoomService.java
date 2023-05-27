package com.example.accessingdatamysql.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.accessingdatamysql.Entity.Room;

import com.example.accessingdatamysql.Repository.RoomRepository;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepo;

    public String addRoom(Room room) {
        roomRepo.save(room);
        return "Room has been added";
    }

}
