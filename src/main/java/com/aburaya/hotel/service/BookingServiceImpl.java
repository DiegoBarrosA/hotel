package com.aburaya.hotel.service;
import org.springframework.stereotype.Service;
import com.aburaya.hotel.model.Booking;
import com.aburaya.hotel.repository.BookingRepository;
import java.util.List;


@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository = new BookingRepository();

    @Override
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @Override
    public void createBooking(Booking booking) {
        bookingRepository.addBooking(booking);
    }
    
    @Override
    public Booking getBookingById(int id) {
        return bookingRepository.findBookingById(id);
    }

    @Override
    public void updateBooking(int id, Booking booking) {
        bookingRepository.updateBooking(id, booking);
    }

    @Override
    public void deleteBooking(int id) {
        bookingRepository.deleteBooking(id);
    }

}
