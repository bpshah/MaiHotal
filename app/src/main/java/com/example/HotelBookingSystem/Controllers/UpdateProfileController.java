package com.example.HotelBookingSystem.Controllers;

import android.content.Context;

import com.example.HotelBookingSystem.DatabaseHelper;

public class UpdateProfileController {
    DatabaseHelper db;

    public boolean updateProfile(String fname, String lname, String email, String phone, String addr, String uname,
                                 String ccnum, String cctype, String ccdate, String pwd, Context c){
        db = new DatabaseHelper(c);
        return db.updateProfile(fname,lname,email,phone,addr,uname,ccnum,cctype,ccdate,pwd);
    }
}
