package com.aburaya.hotel.service.booking;


import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.aburaya.hotel.model.Booking;

@Service
public interface BookingService {
    List<Booking> getAllBookings();
    Booking createBooking(Booking booking);
    Optional<Booking> getBookingById(Integer id);
    Booking updateBooking(Integer id, Booking booking);
    void deleteBooking(Integer id);
}
