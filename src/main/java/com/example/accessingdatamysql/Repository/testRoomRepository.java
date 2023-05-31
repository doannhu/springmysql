package com.example.accessingdatamysql.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

import com.example.accessingdatamysql.Entity.Room;

public interface testRoomRepository extends PagingAndSortingRepository<Room, Integer> {
 @Query(value = "SELECT r FROM Room r ") Page<Room> getRooms(Pageable pageable);
}
