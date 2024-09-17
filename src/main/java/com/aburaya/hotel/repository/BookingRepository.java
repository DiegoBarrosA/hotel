package com.aburaya.hotel.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.aburaya.hotel.model.Booking;
import com.aburaya.hotel.model.Guest;
import com.aburaya.hotel.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Integer > {


}
