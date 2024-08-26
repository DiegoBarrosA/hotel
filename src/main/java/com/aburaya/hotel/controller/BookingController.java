package com.aburaya.hotel.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.aburaya.hotel.service.BookingService;
import com.aburaya.hotel.model.Booking;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

     
    private final BookingService bookingService;
    
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        if (bookings.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }
    
    @PostMapping
    public ResponseEntity<Void> createBookingEntity(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Booking>  updateUser(@PathVariable int id, @RequestBody Booking booking) {
        if (id !=booking.getId() || bookingService.getBookingById(id).equals(booking)  || bookingService.getBookingById(id) == null) 
        {
            return ResponseEntity.badRequest().build();
        }
        bookingService.updateBooking(id, booking);
        return ResponseEntity.ok().build();
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int id) {
        if(bookingService.getBookingById(id) == null){
            return ResponseEntity.badRequest().build();
        }
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

}
