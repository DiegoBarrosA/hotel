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

import com.aburaya.hotel.model.Booking;
import com.aburaya.hotel.service.booking.BookingService;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    @GetMapping("/{id}")
    public Optional<Booking>  getBookingById(@PathVariable Integer id) {

        return bookingService.getBookingById(id);
    }
    @PostMapping
    public Booking createBookingEntity(@RequestBody Booking booking) {
       
        return   bookingService.createBooking(booking);
    }
    @PutMapping("/{id}")
    public Booking  updateUser(@PathVariable Integer id, @RequestBody Booking booking) {

        return bookingService.updateBooking(id, booking);
    }
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Integer id) {
         bookingService.deleteBooking(id);
    }
}
