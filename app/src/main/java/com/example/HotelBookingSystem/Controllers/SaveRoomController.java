package com.example.HotelBookingSystem.Controllers;

import android.content.Context;

import com.example.HotelBookingSystem.DatabaseHelper;

public class SaveRoomController {

    DatabaseHelper db;

    public boolean saveRoom(String rtype, String weekdayprice, String weekendprice, String avail, String hotel, String roomno,
                                  Context c){
        db = new DatabaseHelper(c);
        return db.saveRoom(rtype,Double.parseDouble(weekdayprice),Double.parseDouble(weekendprice),avail,hotel,Integer.parseInt(roomno));
    }

}
