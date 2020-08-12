package com.example.HotelBookingSystem.Controllers;

import android.content.Context;

import com.example.HotelBookingSystem.DatabaseHelper;
import com.example.HotelBookingSystem.Models.Reservation;

import java.text.ParseException;

public class ModifyReservationContoller {

    DatabaseHelper db;
    double price;
    Reservation r = new Reservation();
    public boolean modifyreservation(String checkindate, String checkoutdate, String roomtype, int adults, int children, int noofrooms,
                                     int id, Context c) throws ParseException {
        db = new DatabaseHelper(c);
        price = r.calculateCost(checkindate,checkoutdate,roomtype,noofrooms);
        this.setPrice(r.calculateCost(checkindate,checkoutdate,roomtype,noofrooms));
        long days = r.nooofdays(checkoutdate,checkindate);
        return db.modifyreservation(checkindate,checkoutdate,roomtype,adults,children,noofrooms,price,id,days);
    }

    public boolean deleteReservation(int id,Context c){
        db = new DatabaseHelper(c);
        return db.deletereservation(id);
    }

    public String getPrice(){
        return String.valueOf(price);
    }

    public void setPrice(double price){
        this.price = price;
    }

}
