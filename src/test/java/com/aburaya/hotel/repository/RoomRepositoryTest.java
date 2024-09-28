package com.aburaya.hotel.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.aburaya.hotel.controller.RoomController;
import com.aburaya.hotel.model.Room;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class RoomRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void saveRoomTest() {
        Room room = new Room();
        room.setName("My room");
        room.setBeds(3);
        Room result = roomRepository.save(room);
        assertNotNull(result.getId());
        assertEquals("My room",result.getName());
        logger.info("Returned {}",result.getName());
        assertEquals(3,result.getBeds());

    }

}