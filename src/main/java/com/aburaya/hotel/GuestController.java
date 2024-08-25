package com.aburaya.hotel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class  GuestController {
    private static List<Guest> guests = new ArrayList<>();

    public GuestController(){

        guests.add(new Guest(1,"John","Doe","First Avenue 12", DateUtils.parseDate("13/01/1999")));
        guests.add(new Guest(2,"Jane","McDonald","September 18th 1092", DateUtils.parseDate("01/05/1980")));
        guests.add(new Guest(3,"Louis","Clark","Second Avenue 12", DateUtils.parseDate("02/08/1972")));


    }
    


    @GetMapping("/guest")
    public List<Guest> getGuests() {
        return guests;
    }

    @GetMapping("/guest/{id}")
    public Guest getGuestById(@PathVariable("id") int id) {
        for (Guest guest : guests) {
            if (guest.getId() == id) {
                return guest;
            }
        };
        return null;
    }
}



