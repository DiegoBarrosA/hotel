package com.aburaya.hotel.service.guest;


import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.aburaya.hotel.model.Guest;

@Service
public interface GuestService {
    List<Guest> getAllGuests();
    Guest createGuest(Guest guest);
    Optional<Guest> getGuestById(Integer id);
    Guest updateGuest(Integer id, Guest guest);
    void deleteGuest(Integer id);
}
