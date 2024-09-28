package com.aburaya.hotel.service.room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aburaya.hotel.model.Room;
import com.aburaya.hotel.repository.RoomRepository;

import java.util.List;

import java.util.Optional;
@Service
public class RoomServiceImpl implements RoomService{
@Autowired
private RoomRepository roomRepository;
    @Override
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @Override
    public Room createRoom(Room room) {
      return  roomRepository.save(room);
    }
    
    @Override
    public Optional<Room>  getRoomById(Integer id) {
        return roomRepository.findById(id);
    }
 
    @Override
    public Room updateRoom(Integer id, Room room) {

        if(roomRepository.existsById(id)){
            room.setId(id);
            return roomRepository.save(room);
        }else{return null; }
    }

    @Override
    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room findRoomByName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'findRoomByName'");
    }

}
