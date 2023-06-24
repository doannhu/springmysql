package com.example.accessingdatamysql.Service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.DTO.RoomDTO;
import com.example.accessingdatamysql.Entity.Room;
import com.example.accessingdatamysql.Entity.UserInfo;
import com.example.accessingdatamysql.Repository.OwnerRepository;
//import com.example.accessingdatamysql.Entity.UserInfo;
import com.example.accessingdatamysql.Repository.RoomRepository;
import com.example.accessingdatamysql.Repository.UserInfoRepository;
import com.example.accessingdatamysql.Entity.Owner;

import java.util.stream.Collector;
//import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepo;



    @Autowired
    private UserService userService;



    public String addRoom(Room room) {
        
        userService.addUser(room.getUserInfo());
        roomRepo.save(room);
        
        return "room has been added";
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

    public Room updateRoom(Room roomRequest, Integer id) {
            Room roomToUpdate = roomRepo.findById(id).get();
            roomToUpdate.setTitle(roomRequest.getTitle());
            roomToUpdate.setDescription(roomRequest.getDescription());
            roomToUpdate.setArea(roomRequest.getArea());
            roomToUpdate.setPrice(roomRequest.getPrice());
            roomToUpdate.setCapacity(roomRequest.getCapacity());
            roomToUpdate.setIsRented(roomRequest.getIsRented());
            roomToUpdate.setIsAvailable(roomRequest.getIsAvailable());

            return roomRepo.save(roomToUpdate);
    }

}
