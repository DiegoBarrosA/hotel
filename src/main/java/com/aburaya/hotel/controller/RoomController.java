package com.aburaya.hotel.controller;
  
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.aburaya.hotel.service.RoomService;
import com.aburaya.hotel.model.Room;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
    @GetMapping("/{id}")
    public Optional<Room>  getRoomById(@PathVariable Integer id) {

        return roomService.getRoomById(id);
    }
    @PostMapping
    public Room createRoomEntity(@RequestBody Room room) {
       
        return   roomService.createRoom(room);
    }
    @PutMapping("/{id}")
    public Room  updateUser(@PathVariable Integer id, @RequestBody Room room) {

        return roomService.updateRoom(id, room);
    }
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Integer id) {
         roomService.deleteRoom(id);
    }
}
