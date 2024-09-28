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

import com.aburaya.hotel.model.Guest;
import com.aburaya.hotel.service.guest.GuestService;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
@RestController
@RequestMapping("/api/guest")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }
    @GetMapping("/{id}")
    public Optional<Guest>  getGuestById(@PathVariable Integer id) {

        return guestService.getGuestById(id);
    }
    @PostMapping
    public Guest createGuestEntity(@RequestBody Guest guest) {
       
        return   guestService.createGuest(guest);
    }
    @PutMapping("/{id}")
    public Guest  updateUser(@PathVariable Integer id, @RequestBody Guest guest) {

        return guestService.updateGuest(id, guest);
    }
    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Integer id) {
         guestService.deleteGuest(id);
    }
}
