package com.aburaya.service;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aburaya.hotel.model.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.aburaya.hotel.repository.RoomRepository;
import com.aburaya.hotel.service.RoomServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {
    @InjectMocks
    private RoomServiceImpl roomService;
    @Mock
    private RoomRepository roomRepositoryMock;
    @Test
    public void saveRoomTest() {
        Room room = new Room();
        room.setName("My Room");
        when(roomRepositoryMock.save(any())).thenReturn(room);
        Room result = roomService.createRoom(room);
        assertEquals("My Room", result.getName());
    }
}
