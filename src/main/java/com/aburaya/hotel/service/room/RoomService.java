package com.aburaya.hotel.service.room;


import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.aburaya.hotel.model.Room;

@Service
public interface RoomService {
    List<Room> getAllRooms();
    Room createRoom(Room room);
    Optional<Room> getRoomById(Integer id);
    Room updateRoom(Integer id, Room room);
    void deleteRoom(Integer id);
}
