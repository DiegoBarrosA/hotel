package com.aburaya.hotel.service;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aburaya.hotel.model.Guest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.aburaya.hotel.repository.GuestRepository;
import com.aburaya.hotel.service.guest.GuestServiceImpl;

@ExtendWith(MockitoExtension.class)
public class GuestServiceTest {
    @InjectMocks
    private GuestServiceImpl guestService;
    @Mock
    private GuestRepository guestRepositoryMock;
    @Test
    public void saveGuestTest() {
        Guest guest = new Guest();
        guest.setFirstName("John");
        when(guestRepositoryMock.save(any())).thenReturn(guest);
        Guest result = guestService.createGuest(guest);
        assertEquals("John", result.getFirstName());
    }
}
