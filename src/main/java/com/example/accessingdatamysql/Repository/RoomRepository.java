package com.example.accessingdatamysql.Repository;

import com.example.accessingdatamysql.Entity.Room;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
