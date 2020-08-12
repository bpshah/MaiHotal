package com.example.HotelBookingSystem.Models;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable {

    private int reserveid;
    private String username;
    private String checkindate;

    public int getReserveid() {
        return reserveid;
    }

    public void setReserveid(int reserveid) {
        this.reserveid = reserveid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public int getNoofroom() {
        return noofroom;
    }

    public void setNoofroom(int noofroom) {
        this.noofroom = noofroom;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    private String  checkoutdate;
    private int days;
    private String roomtype;
    private int noofroom;
    private String bookingdate;
    private int adults;
    private int children;
    private String hotel;
    private double cost;


}