package com.aburaya.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name= "name")
    private String name;
    @Column(name= "type")
    private String type;
    @Column(name= "floor")
    private Integer floor;
    @Column(name= "beds")
    private Integer beds;
    @Column(name= "sector")
    private String sector;
    @Column(name= "available")
    private Boolean available;
}
