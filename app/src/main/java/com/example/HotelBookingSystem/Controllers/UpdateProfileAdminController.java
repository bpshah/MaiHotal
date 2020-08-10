package com.example.HotelBookingSystem.Controllers;

import android.content.Context;

import com.example.HotelBookingSystem.DatabaseHelper;

public class UpdateProfileAdminController {

    DatabaseHelper db;

    public boolean updateProfileAdmin(String fname, String lname, String email, String phone, String addr, String uname, Context c){
        db = new DatabaseHelper(c);
        return db.updateProfileAdmin(fname,lname,email,phone,addr,uname);
    }
}
