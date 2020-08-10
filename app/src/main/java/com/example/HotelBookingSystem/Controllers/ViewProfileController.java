package com.example.HotelBookingSystem.Controllers;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import com.example.HotelBookingSystem.DatabaseHelper;

public class ViewProfileController {
    DatabaseHelper db;

    public Cursor getProfile(String username, Context c){
        db = new DatabaseHelper(c);
        return db.getProfile(username);
    }
}
