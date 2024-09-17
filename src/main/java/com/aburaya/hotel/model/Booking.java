package com.aburaya.hotel.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "guest", referencedColumnName = "id")
    private Guest guest;
    @OneToOne
    @JoinColumn(name = "room", referencedColumnName = "id")
    private Room room;
    @Column(name = "createdDate")
    private Date createdDate;
    @Column(name = "checkInDate")
    private Date checkInDate;
    @Column(name = "checkOutDate")
    private Date checkOutDate;
}
