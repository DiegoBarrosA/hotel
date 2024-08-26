package com.aburaya.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    private int id;
    private String name;
    private String type;
    private int floor;
    private int beds;
    private String sector;
    private Boolean available;
}
