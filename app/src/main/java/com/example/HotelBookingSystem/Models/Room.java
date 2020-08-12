package com.example.HotelBookingSystem.Models;

import java.io.Serializable;

public class Room implements Serializable {

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public double getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(double roomprice) {
        this.roomprice = roomprice;
    }

    public double getRoomweekendprice() {
        return roomweekendprice;
    }

    public void setRoomweekendprice(double roomweekendprice) {
        this.roomweekendprice = roomweekendprice;
    }

    public String getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(String roomstatus) {
        this.roomstatus = roomstatus;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    private int roomno;
    private double roomprice;
    private double roomweekendprice;
    private String roomstatus;
    private String roomtype;
    private String hotel;
}
