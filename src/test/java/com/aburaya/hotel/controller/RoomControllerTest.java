package com.aburaya.hotel.controller;


import com.aburaya.hotel.model.Room;
import  com.aburaya.hotel.service.room.RoomService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomControllerTest {

    @Mock
    private RoomService roomService;

    @InjectMocks
    private RoomController roomController;

    private Room room;
    private RoomUpdateRequest updateRequest;

    @BeforeEach
    void setUp() {
        room = new Room();
        room.setId(1L);
        room.setRoomname("testroom");
        room.setEmail("test@example.com");

        updateRequest = new RoomUpdateRequest();
        updateRequest.setRoomname("updatedRoom");
        updateRequest.setEmail("updated@example.com");
    }

    @Test
    void createRoom() {
        // Arrange
        when(roomService.saveRoom(any(Room.class))).thenReturn(room);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.createRoom(room);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        EntityModel<Room> savedRoomModel = response.getBody();
        assertNotNull(savedRoomModel);
        assertEquals(room.getId(), savedRoomModel.getContent().getId());
        assertTrue(savedRoomModel.hasLink("self"));
        verify(roomService).saveRoom(any(Room.class));
    }

    @Test
    void getRoomById_found() {
        // Arrange
        when(roomService.findRoomById(1L)).thenReturn(Optional.of(room));

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomById(1L);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<Room> foundRoomModel = response.getBody();
        assertNotNull(foundRoomModel);
        assertEquals(room.getId(), foundRoomModel.getContent().getId());
        assertTrue(foundRoomModel.hasLink("self"));
        verify(roomService).findRoomById(1L);
    }

    @Test
    void getRoomById_notFound() {
        // Arrange
        when(roomService.findRoomById(1L)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomById(1L);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(roomService).findRoomById(1L);
    }

    @Test
    void getRoomByRoomname_found() {
        // Arrange
        when(roomService.findRoomByRoomname("testroom")).thenReturn(room);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomByRoomname("testroom");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<Room> foundRoomModel = response.getBody();
        assertNotNull(foundRoomModel);
        assertEquals(room.getRoomname(), foundRoomModel.getContent().getRoomname());
        assertTrue(foundRoomModel.hasLink("self"));
        verify(roomService).findRoomByRoomname("testroom");
    }

    @Test
    void getRoomByRoomname_notFound() {
        // Arrange
        when(roomService.findRoomByRoomname("testroom")).thenReturn(null);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomByRoomname("testroom");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(roomService).findRoomByRoomname("testroom");
    }

    @Test
    void getRoomByEmail_found() {
        // Arrange
        when(roomService.findRoomByEmail("test@example.com")).thenReturn(room);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomByEmail("test@example.com");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<Room> foundRoomModel = response.getBody();
        assertNotNull(foundRoomModel);
        assertEquals(room.getEmail(), foundRoomModel.getContent().getEmail());
        assertTrue(foundRoomModel.hasLink("self"));
        verify(roomService).findRoomByEmail("test@example.com");
    }

    @Test
    void getRoomByEmail_notFound() {
        // Arrange
        when(roomService.findRoomByEmail("test@example.com")).thenReturn(null);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.getRoomByEmail("test@example.com");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(roomService).findRoomByEmail("test@example.com");
    }

    @Test
    void patchRoom() {
        // Arrange
        when(roomService.updateRoom(eq(1L), any(RoomUpdateRequest.class))).thenReturn(room);

        // Act
        ResponseEntity<EntityModel<Room>> response = roomController.patchRoom(1L, updateRequest);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        EntityModel<Room> updatedRoomModel = response.getBody();
        assertNotNull(updatedRoomModel);
        assertEquals(room.getId(), updatedRoomModel.getContent().getId());
        assertTrue(updatedRoomModel.hasLink("self"));
        verify(roomService).updateRoom(eq(1L), any(RoomUpdateRequest.class));
    }

    @Test
    void getAllRooms() {
        // Arrange
        List<Room> roomList = List.of(room);
        when(roomService.findAllRooms()).thenReturn(roomList);

        // Act
        ResponseEntity<CollectionModel<EntityModel<Room>>> response = roomController.getAllRooms();
        CollectionModel<EntityModel<Room>> foundRoomsModel = response.getBody();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(foundRoomsModel);
        assertEquals(1, foundRoomsModel.getContent().size());
        assertTrue(foundRoomsModel.hasLink("self"));
        verify(roomService).findAllRooms();
    }

    @Test
    void deleteRoom() {
        // Arrange
        doNothing().when(roomService).deleteRoomById(1L);

        // Act
        ResponseEntity<Void> response = roomController.deleteRoom(1L);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(roomService).deleteRoomById(1L);
    }
}