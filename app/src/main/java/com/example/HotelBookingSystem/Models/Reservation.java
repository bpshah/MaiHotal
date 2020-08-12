package com.example.HotelBookingSystem.Models;

import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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

    public double calculateCost(String checkindate,String checkoutdate,String roomtype,int noofroom) throws ParseException {
        double cost = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date firstDate = (Date) sdf.parse(checkindate);
        Date secondDate = (Date) sdf.parse(checkoutdate);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        Calendar startCal = Calendar.getInstance();
        startCal.setTime(firstDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(secondDate);

        int workDays = 0;
        do {
            //excluding start date
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                ++workDays;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

        long weekenddays = days-workDays;

        if(roomtype.equals("Standard")){
            cost = (workDays*100 + weekenddays*150)*noofroom + (workDays*100 + weekenddays*150)*noofroom*0.0825;
        }
        else if(roomtype.equals("Deluxe")){
            cost = (workDays*135 + weekenddays*185)*noofroom + (workDays*135 + weekenddays*185)*noofroom*0.0825;
        }
        else if(roomtype.equals("Suite")){
            cost = (workDays*225 + weekenddays*275)*noofroom + (workDays*225 + weekenddays*275)*noofroom*0.0825;
        }

        return cost;
    }

    public long nooofdays(String checkoutdate,String checkindate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date firstDate = (Date) sdf.parse(checkindate);
        Date secondDate = (Date) sdf.parse(checkoutdate);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return days;
    }


}