package com.aburaya.hotel;
import java.util.Date;


public class Guest {
private int id;
private String firstName;
private String lastName;
private String address;
private Date birthDate;
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getFirstName() {
    return firstName;
}
public void setFirstName(String firstName) {
    this.firstName = firstName;
}
public String getLastName() {
    return lastName;
}
public void setLastName(String lastName) {
    this.lastName = lastName;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}
public Date getBirthDate() {
    return birthDate;
}
public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
}
public Guest(int id, String firstName, String lastName, String address, Date birthDate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.birthDate = birthDate;
}


}
