package com.aburaya.hotel.model;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Guest {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthDate;
}
