package com.aburaya.hotel.model;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {
    private int id;
    private Guest guest;
    private Room room;
    private Date createdDate;
    private Date checkInDate;
    private Date checkOutDate;
}
