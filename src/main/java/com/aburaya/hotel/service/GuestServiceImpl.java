package com.aburaya.hotel.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aburaya.hotel.model.Guest;
import com.aburaya.hotel.repository.GuestRepository;
import java.util.List;

import java.util.Optional;
@Service
public class GuestServiceImpl implements GuestService{
@Autowired
private GuestRepository guestRepository;
    @Override
    public List<Guest> getAllGuests(){
        return guestRepository.findAll();
    }

    @Override
    public Guest createGuest(Guest guest) {
      return  guestRepository.save(guest);
    }
    
    @Override
    public Optional<Guest>  getGuestById(Integer id) {
        return guestRepository.findById(id);
    }
 
    @Override
    public Guest updateGuest(Integer id, Guest guest) {

        if(guestRepository.existsById(id)){
            guest.setId(id);
            return guestRepository.save(guest);
        }else{return null; }
    }

    @Override
    public void deleteGuest(Integer id) {
        guestRepository.deleteById(id);
    }

}
