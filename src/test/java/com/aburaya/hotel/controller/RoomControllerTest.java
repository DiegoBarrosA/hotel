package com.aburaya.hotel.controller;

import com.aburaya.hotel.model.Room;
import com.aburaya.hotel.service.room.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomControllerTest {

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room();
        room.setId(1);
        room.setName("Test Room");
        room.setBeds(2);

    }

    @SuppressWarnings("null")
    @Test
    void createRoom() {
        // Arrange
        when(roomService.createRoom(any(Room.class))).thenReturn(room);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.createRoom(room);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        EntityModel<Room> savedRoomModel = response.getBody();
        assertNotNull(savedRoomModel);
        assertEquals(room.getId(), savedRoomModel.getContent().getId());
        assertTrue(savedRoomModel.hasLink("self"));
        verify(roomService).createRoom(any(Room.class));
    }

    @SuppressWarnings("null")
    @Test
    void getRoomById_found() {
        // Arrange
        when(roomService.getRoomById(1)).thenReturn(Optional.of(room));

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<Room> foundRoomModel = response.getBody();
        assertNotNull(foundRoomModel);
        assertEquals(room.getId(), foundRoomModel.getContent().getId());
        assertTrue(foundRoomModel.hasLink("self"));
        verify(roomService).getRoomById(1);
    }

    @Test
    void getRoomById_notFound() {
        // Arrange
        when(roomService.getRoomById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomById(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(roomService).getRoomById(1);
    }

    @SuppressWarnings("null")
    @Test
    void getRoomByRoomname_found() {
        // Arrange
        when(roomService.findRoomByName("testroom")).thenReturn(room);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomByRoomname("testroom");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<Room> foundRoomModel = response.getBody();
        assertNotNull(foundRoomModel);
        assertEquals(room.getName(), foundRoomModel.getContent().getName());
        assertTrue(foundRoomModel.hasLink("self"));
        verify(roomService).findRoomByName("testroom");
    }

    @Test
    void getRoomByRoomname_notFound() {
        // Arrange
        when(roomService.findRoomByName("testroom")).thenReturn(null);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomByRoomname("testroom");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(roomService).findRoomByName("testroom");
    }

    @Test
    void getAllRooms() {
        // Arrange
        List<Room> roomList = List.of(room);
        when(roomService.getAllRooms()).thenReturn(roomList);

        // Act
        ResponseEntity<CollectionModel<EntityModel<Room>>> response = roomController.getAllRooms();
        CollectionModel<EntityModel<Room>> foundRoomsModel = response.getBody();
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(foundRoomsModel);
        assertEquals(1, foundRoomsModel.getContent().size());
        assertTrue(foundRoomsModel.hasLink("self"));
        verify(roomService).getAllRooms();
    }

    @Test
    void deleteRoom() {
        // Arrange
        doNothing().when(roomService).deleteRoom(1);

        // Act
        ResponseEntity<Void> response = roomController.deleteRoom(1);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(roomService).deleteRoom(1);
    }
}