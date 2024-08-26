package com.aburaya.hotel.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.aburaya.hotel.model.Booking;
import com.aburaya.hotel.model.Guest;
import com.aburaya.hotel.model.Room;

public class BookingRepository {

    public Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
     }
    private final List<Booking> bookings = new ArrayList<>();

    public List<Booking> findAll() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public Booking findBookingById(int id) {
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                return booking;
            }
        }
    return null;
    }

public void updateBooking(int id, Booking updateBooking) {
    for (int i = 0; i < bookings.size(); i++) {
        if (bookings.get(i).getId() == id) {
            bookings.set(i, updateBooking);
            return;
        }
    }
}

public void deleteBooking(int id) {
    for (int i = 0; i < bookings.size(); i++) {
        if (bookings.get(i).getId() == id) {
            bookings.remove(i);
            return;
        }
    }
}

    public BookingRepository() {
        // Inicializar la listas con usuarios
        bookings.add(new Booking(1,new Guest(1,"Pedro","Perez","Calle Vieja 66",parseDate("07/08/1998")),new Room(1, "213","Premium",2,2,"Ala B",true),parseDate("01/12/2023"),parseDate("01/05/2024"),parseDate("10/05/2024"))); 
        bookings.add(new Booking(2,new Guest(2,"Juan","Jofré","Calle Nueva 021",parseDate("07/01/1999")),new Room(12, "313","Tourist",3,3,"Ala B",true),parseDate("04/12/2023"),parseDate("07/06/2024"),parseDate("15/06/2024"))); 
    }

}
