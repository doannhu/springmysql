package com.example.accessingdatamysql.Controller;

import com.example.accessingdatamysql.DTO.RoomDTO;
import com.example.accessingdatamysql.DTO.RoomRentedDTO;
import com.example.accessingdatamysql.Entity.Room;
import com.example.accessingdatamysql.Repository.RoomRepository;
import com.example.accessingdatamysql.Repository.testRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.accessingdatamysql.Service.RoomService;

import java.io.IOException;
import java.util.List;


@RestController // This means that this class is a Controller
@RequestMapping("/room") // This means URL's start with /demo (after Application path)
public class RoomController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;

    @PostMapping("/add") // Map ONLY POST Requests
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addNewRoom (@RequestBody Room room) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
            return roomService.addRoom(room);
    }


    @GetMapping("/all")
    // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    // public @ResponseBody Iterable<Room> getAllRooms() {
    //     // This returns a JSON or XML with the users
    //     return roomRepository.findAll();
    // }
    public List<Room> all() {
        return roomService.all();
    }

    @GetMapping("/all-dto")
    public List<RoomDTO> allDTO() {
        return roomService.allDTO();
    }


    @Autowired
    private testRoomRepository tRoomRepository;

    @GetMapping("/all-pageable")
    public ResponseEntity<?> getRoomPageable(
        @RequestParam(defaultValue = "0") final Integer pageNumber,
        @RequestParam(defaultValue = "2") final Integer size
    ) {
        return ResponseEntity.ok(tRoomRepository.getRooms(PageRequest
        .of(pageNumber, size)));
    }


    @GetMapping("/all-pageable-v2")
    public Page<Room> findAll(
        @RequestParam Integer pageNumber,
        @RequestParam Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        return tRoomRepository.findAll(pageRequest);
    }

    @GetMapping("/all-pageable-v3")
    public Page<RoomDTO> findAllDTOPage(
        @RequestParam Integer pageNumber,
        @RequestParam Integer size
    ) {
        return roomService.pageableRoomDTOv3(pageNumber, size);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_OWNER')")
    public String updateRoom(@RequestBody Room roomRequest, @PathVariable Integer id ) {

        return roomService.updateRoom(roomRequest, id);

    }

    // @GetMapping("/currentUserName")
    // public String getUserName() {
    //     Room room = roomRepository.findById(1).orElseThrow(() -> new RoomNotFoundException(1));

    //     String nameCheck = room.getUserInfo().getName();

    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // get current user information

    //     String currentUserName = authentication.getName();

    //     String name = nameCheck + currentUserName;

    //     return name;
    // }

    // @GetMapping("/{id}")
    // public RoomRentedDTO getOne(@PathVariable Integer id) {

    //     // check if request user is renter

    //     Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));

    //     String nameCheck = room.getUserInfo().getName();

    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    //     String currentUserName = authentication.getName();

    //     if (nameCheck.equals(currentUserName)) {
    //         // control return - part of entity
    //         RoomRentedDTO rentedRoomDTO = new RoomRentedDTO(room.getId(), 
    //                                                     room.getTitle(),
    //                                                     room.getDescription(), 
    //                                                     room.getPrice(), 
    //                                                     room.getArea(), 
    //                                                     room.getRating(), 
    //                                                     room.getCapacity(),
    //                                                     room.getIsRented(),
    //                                                     room.getIsAvailable(),
    //                                                     room.getUserInfo().getName());

    //         return rentedRoomDTO;
    //     }
    //     else return null;
    // }
    
}
