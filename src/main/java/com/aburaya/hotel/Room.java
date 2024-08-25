package com.aburaya.hotel;

public class Room {
    private int id;
    private String name;
    private String type;
    private int floor;
    private int beds;
    private String sector;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }
    public int getBeds() {
        return beds;
    }
    public void setBeds(int beds) {
        this.beds = beds;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public Room(int id, String name, String type, int floor, int beds, String sector) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.floor = floor;
        this.beds = beds;
        this.sector = sector;
    }

}
