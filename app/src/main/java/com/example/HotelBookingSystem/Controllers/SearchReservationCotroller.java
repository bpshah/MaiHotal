package com.example.HotelBookingSystem.Controllers;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import com.example.HotelBookingSystem.DatabaseHelper;
import com.example.HotelBookingSystem.Models.Reservation;
import com.example.HotelBookingSystem.Models.Room;

import java.util.ArrayList;

public class SearchReservationCotroller {

    DatabaseHelper db;
    Reservation reserve;
    ArrayList<Reservation> reservationlist;
    public ArrayList<Reservation> searchreservations(String date, String username, Context c){

        db = new DatabaseHelper(c);
        Intent intent;
        Cursor cursor = db.searchreservation(date,username);
        reservationlist = new ArrayList<Reservation>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                reserve = new Reservation();
                reserve.setReserveid(cursor.getInt(cursor.getColumnIndexOrThrow("reserveid")));
                reserve.setUsername(cursor.getString(cursor.getColumnIndexOrThrow("username")));
                reserve.setCheckindate(cursor.getString(cursor.getColumnIndexOrThrow("checkindate")));
                reserve.setCheckoutdate(cursor.getString(cursor.getColumnIndexOrThrow("checkoutdate")));
                reserve.setDays(cursor.getInt(cursor.getColumnIndexOrThrow("days")));
                reserve.setRoomtype(cursor.getString(cursor.getColumnIndexOrThrow("roomtype")));
                reserve.setNoofroom(cursor.getInt(cursor.getColumnIndexOrThrow("noofroom")));
                reserve.setBookingdate(cursor.getString(cursor.getColumnIndexOrThrow("bookingdate")));
                reserve.setAdults(cursor.getInt(cursor.getColumnIndexOrThrow("adults")));
                reserve.setChildren(cursor.getInt(cursor.getColumnIndexOrThrow("children")));
                reserve.setHotel(cursor.getString(cursor.getColumnIndexOrThrow("hotel")));
                reserve.setCost(cursor.getDouble(cursor.getColumnIndexOrThrow("cost")));
                reservationlist.add(reserve);
            }
            System.out.println(reservationlist.get(0).getCheckindate());
            return reservationlist;

        }
        else
            return null;
    }

}
