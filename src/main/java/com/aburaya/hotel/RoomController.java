package com.aburaya.hotel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {
    public static List<Room> rooms = new ArrayList<>();    
    public RoomController() {
        rooms.add(new Room(1,"340","Suite",24,2,"Premium"));
        rooms.add(new Room(2,"140","Suite",10,2,"Tourist"));
        rooms.add(new Room(3,"130","Suite",1,1,"Premium"));
    }
    @GetMapping("/room")
    public List<Room> getRooms() {
        return rooms;
    }
           @GetMapping("/room/{id}")
    public Room getRoomById(@PathVariable("id") int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        };
        return null;
    }
}
