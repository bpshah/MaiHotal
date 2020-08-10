package com.example.HotelBookingSystem.Controllers;

import android.content.Context;

import com.example.HotelBookingSystem.DatabaseHelper;

public class DeleteProfileAdminController {

    DatabaseHelper db;

    public boolean deleteProfileAdmin(String uname, Context c){
        db = new DatabaseHelper(c);
        return db.deleteProfileAdmin(uname);
    }

}
