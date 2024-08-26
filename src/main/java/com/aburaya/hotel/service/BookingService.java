package com.aburaya.hotel.service;


import java.util.List;
import org.springframework.stereotype.Service;
import com.aburaya.hotel.model.Booking;

@Service
public interface BookingService {
    List<Booking> getAllBookings();
    void createBooking(Booking booking);
    Booking getBookingById(int id);
    void updateBooking(int id, Booking booking);
    void deleteBooking(int id);
}
