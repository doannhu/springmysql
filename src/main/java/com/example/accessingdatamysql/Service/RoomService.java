package com.example.accessingdatamysql.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.DTO.RoomDTO;
import com.example.accessingdatamysql.Entity.Room;
import com.example.accessingdatamysql.Entity.UserInfo;
import com.example.accessingdatamysql.Repository.RoomRepository;


import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepo;

    // private PasswordEncoder passwordEncoder;

    public String addRoom(Room room) {
        
        // UserInfo copyUserInfo = new UserInfo(0, room.getUserInfo().getName(), room.getUserInfo().getEmail(), passwordEncoder.encode(room.getUserInfo().getPassword()), room.getUserInfo().getRoles());

        // Room copyRoom = new Room(0, room.getTitle(), room.getDescription(), room.getPrice(), room.getArea(), room.getRating(), room.getCapacity(), copyUserInfo);

        roomRepo.save(room);
        
        return "Room has been added";
    }

    public List<Room> all() {
        return roomRepo.findAll();
    }

    public List<RoomDTO> allDTO() {
        return roomRepo.findAll().stream().map(room -> new RoomDTO(room.getId(), 
                                                                    room.getTitle(), 
                                                                    room.getDescription(), 
                                                                    room.getPrice(), 
                                                                    room.getArea(), 
                                                                    room.getRating(), 
                                                                    room.getCapacity())).collect(Collectors.toList());
    }

}
