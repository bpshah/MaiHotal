package com.example.HotelBookingSystem.Controllers;

import android.content.Context;

import com.example.HotelBookingSystem.DatabaseHelper;
import com.example.HotelBookingSystem.Models.Reservation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class AddReservationController {
    DatabaseHelper db;
    Reservation r = new Reservation();
    ArrayList<Integer> array = new ArrayList<>();

    public void addReservation(String checkindate, String checkoutdate, Integer noofroom, String roomtype, Integer adlt, Integer chld, String hotel, String userID, double finalprice, Context contxt) throws ParseException {
        db = new DatabaseHelper(contxt);
        long days = r.nooofdays(checkoutdate,checkindate);
        java.sql.Date bookdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Random rand = new Random();
        Integer reserveID = null;
        boolean present=true;
        while(present!=false){
            reserveID = rand.nextInt(1000);
            present = Arrays.asList(array).contains(reserveID);
        }
        array.add(reserveID);
        db.addReservation(reserveID,userID,checkindate,checkoutdate,days,roomtype,noofroom,bookdate,adlt,chld,hotel,finalprice);

    }
}
