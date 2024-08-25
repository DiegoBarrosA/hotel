package com.aburaya.hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BookingController {
    public static List<Booking> bookings = new ArrayList<>();

    public BookingController() {
// Estas variables fueron presentadas en la clase, sin embargo no me parece que juegen un papel más allá de legibilidad al 
// crear objetos en la lista, no las utilizaré en las otras clases

        int id;
        int idGuest;
        int idRoom;
        Date dateCreated;
        Date checkInDate;
        Date checkOutDate;

        bookings.add(new Booking(id=1,idGuest=1,idRoom=1,dateCreated=DateUtils.parseDate("1/10/2023"),checkInDate=DateUtils.parseDate("01/04/2024"),checkOutDate=DateUtils.parseDate("10/04/2024")));
        bookings.add(new Booking(id=2,idGuest=2,idRoom=3,dateCreated=DateUtils.parseDate("11/12/2023"),checkInDate=DateUtils.parseDate("02/06/2024"),checkOutDate=DateUtils.parseDate("06/06/2024")));
        bookings.add(new Booking(id=3,idGuest=2,idRoom=2,dateCreated=DateUtils.parseDate("11/12/2023"),checkInDate=DateUtils.parseDate("24/06/2024"),checkOutDate=DateUtils.parseDate("01/07/2024")));
        bookings.add(new Booking(id=4,idGuest=3,idRoom=1,dateCreated=DateUtils.parseDate("10/02/2024"),checkInDate=DateUtils.parseDate("10/12/2024"),checkOutDate=DateUtils.parseDate("15/12/2024")));
        bookings.add(new Booking(id=5,idGuest=3,idRoom=1,dateCreated=DateUtils.parseDate("1/10/2023"),checkInDate=DateUtils.parseDate("01/04/2024"),checkOutDate=DateUtils.parseDate("10/04/2024")));

    }

    @GetMapping("/booking")
    public List<Booking> getBookings() {
        return bookings;
    }

        @GetMapping("/booking/{id}")
    public Booking getBookingById(@PathVariable("id") int id) {
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                return booking;
            }
        };
        return null;
    }
}
