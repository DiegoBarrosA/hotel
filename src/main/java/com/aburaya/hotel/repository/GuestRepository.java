package com.aburaya.hotel.repository;

import com.aburaya.hotel.model.Guest;


import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRepository extends JpaRepository<Guest, Integer > {


}
