package com.aburaya.hotel.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aburaya.hotel.model.Booking;
import com.aburaya.hotel.repository.BookingRepository;
import java.util.List;

import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService{
@Autowired
private BookingRepository bookingRepository;
    @Override
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
      return  bookingRepository.save(booking);
    }
    
    @Override
    public Optional<Booking>  getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }
 
    @Override
    public Booking updateBooking(Integer id, Booking booking) {

        if(bookingRepository.existsById(id)){
            booking.setId(id);
            return bookingRepository.save(booking);
        }else{return null; }
    }

    @Override
    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }

}
