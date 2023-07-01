package com.example.accessingdatamysql.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.DTO.RoomDTO;
import com.example.accessingdatamysql.Entity.Room;
import com.example.accessingdatamysql.Entity.UserInfo;
import com.example.accessingdatamysql.Repository.OwnerRepository;

import com.example.accessingdatamysql.Repository.RoomRepository;
import com.example.accessingdatamysql.Repository.UserInfoRepository;
import com.example.accessingdatamysql.Entity.Owner;

import java.util.stream.Collector;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepo;



    @Autowired
    private UserInfoRepository userRepository;



    public String addRoom(Room room) {
        
        // userService.addUser(room.getUserInfo());
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
            
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String ownerRoomCheck = authentication.getName();

            Optional<UserInfo> optionalVal = userRepository.findByName(ownerRoomCheck);
            UserInfo roomOwner = optionalVal.get();
            List<Room> rooms = roomOwner.getRooms();
            boolean roomExist = rooms.contains(roomToUpdate);
            
            if (roomExist) {
                    roomToUpdate.setTitle(roomRequest.getTitle());
                    roomToUpdate.setDescription(roomRequest.getDescription());
                    roomToUpdate.setArea(roomRequest.getArea());
                    roomToUpdate.setPrice(roomRequest.getPrice());
                    roomToUpdate.setCapacity(roomRequest.getCapacity());
                    roomToUpdate.setIsRented(roomRequest.getIsRented());
                    roomToUpdate.setIsAvailable(roomRequest.getIsAvailable());

                    return roomRepo.save(roomToUpdate);
            }
            else {
                return null;
            }


    }

    public Page<RoomDTO> pageableRoomDTOv3(Integer pageNumber, Integer size) {
            PageRequest pageRequest = PageRequest.of(pageNumber, size);
            Page<Room> rooms = roomRepo.findAll(pageRequest);
            return rooms.map(room -> new RoomDTO(room.getId(), 
                                            room.getTitle(), 
                                            room.getDescription(), 
                                            room.getPrice(), 
                                            room.getArea(), 
                                            room.getRating(), 
                                            room.getCapacity()));
            }


}
