package com.aburaya.hotel.repository;
import com.aburaya.hotel.model.Booking;


import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Integer > {


}
