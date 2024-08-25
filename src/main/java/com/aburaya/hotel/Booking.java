package com.aburaya.hotel;

import java.util.Date;

public class Booking {

    private int id;
    private int idGuest;
    private int idRoom;
    private Date dateCreated;
    private Date checkInDateDate;
    private Date checkOutDate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdGuest() {
        return idGuest;
    }
    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }
    public int getIdRoom() {
        return idRoom;
    }
    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getCheckInDateDate() {
        return checkInDateDate;
    }
    public void setCheckInDateDate(Date checkInDateDate) {
        this.checkInDateDate = checkInDateDate;
    }
    public Date getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    public Booking(int id, int idGuest, int idRoom, Date dateCreated, Date checkInDateDate, Date checkOutDate) {
        this.id = id;
        this.idGuest = idGuest;
        this.idRoom = idRoom;
        this.dateCreated = dateCreated;
        this.checkInDateDate = checkInDateDate;
        this.checkOutDate = checkOutDate;
    }

}