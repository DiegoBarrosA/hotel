package com.aburaya.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.aburaya.hotel.model.Room;
import com.aburaya.hotel.service.room.RoomService;

import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Room>>> getAllRooms() {
        logger.info("Getting all rooms");
        List<EntityModel<Room>> rooms = roomService.getAllRooms().stream()
                .map(room -> {
                    EntityModel<Room> roomModel = EntityModel.of(room);
                    roomModel.add(linkTo(methodOn(RoomController.class).getRoomById(room.getId())).withSelfRel());
                    return roomModel;
                }).toList();

        return ResponseEntity.ok(CollectionModel.of(rooms,
                linkTo(methodOn(RoomController.class).getAllRooms()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Room>> getRoomById(@PathVariable Integer id) {
        logger.info("Getting a room by ID: {}", id);
        Optional<Room> room = roomService.getRoomById(id);
        if (room.isPresent()) {
            EntityModel<Room> roomModel = EntityModel.of(room.get());
            roomModel.add(linkTo(methodOn(RoomController.class).getRoomById(id)).withSelfRel());
            return ResponseEntity.ok(roomModel);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<EntityModel<Room>> createRoom(@RequestBody Room room) {
        logger.info("Creating a new room with request: {}", room);
        Room savedRoom = roomService.createRoom(room);
        logger.info("Room created successfully. Room ID: {}", savedRoom.getId());

        EntityModel<Room> roomModel = EntityModel.of(savedRoom);
        roomModel.add(linkTo(methodOn(RoomController.class).getRoomById(savedRoom.getId())).withSelfRel());

        return ResponseEntity.created(
                linkTo(methodOn(RoomController.class).getRoomById(savedRoom.getId())).toUri())
                .body(roomModel);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Integer id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer id) {
        logger.info("Deleting a room with ID: {}", id);
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @GetMapping("/name/{roomname}")
    public ResponseEntity<EntityModel<Room>> getRoomByRoomname(@PathVariable String roomname) {
        logger.info("Getting a room by roomname: {}", roomname);
        Room room = roomService.findRoomByName(roomname);
        if (room != null) {
            EntityModel<Room> roomModel = EntityModel.of(room);
            roomModel.add(linkTo(methodOn(RoomController.class).getRoomByRoomname(roomname)).withSelfRel());

            return ResponseEntity.ok(roomModel);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
