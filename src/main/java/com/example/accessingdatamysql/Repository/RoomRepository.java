package com.example.accessingdatamysql.Repository;

import com.example.accessingdatamysql.Entity.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
}
