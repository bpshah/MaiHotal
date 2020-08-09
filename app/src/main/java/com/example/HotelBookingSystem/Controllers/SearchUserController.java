package com.example.HotelBookingSystem.Controllers;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Toast;

import com.example.HotelBookingSystem.DatabaseHelper;
import com.example.HotelBookingSystem.Models.User;
import com.example.HotelBookingSystem.View.MainActivity;
import com.example.HotelBookingSystem.View.UsersList;

import java.util.ArrayList;

public class SearchUserController {
    DatabaseHelper db;
    User user;
    public ArrayList<User> searchUser(String lastname, Context c){
        db = new DatabaseHelper(c);
        Intent intent;
        Cursor cursor = db.searchUser(lastname);
        ArrayList<User> userList = new ArrayList<User>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                user = new User();
                user.setUsername(cursor.getString(cursor.getColumnIndexOrThrow("username")));
                user.setFirstname(cursor.getString(cursor.getColumnIndexOrThrow("firstname")));
                user.setLastname(cursor.getString(cursor.getColumnIndexOrThrow("lastname")));
                user.setPhone(cursor.getString(cursor.getColumnIndexOrThrow("phone")));
                user.setAddress(cursor.getString(cursor.getColumnIndexOrThrow("address")));
                user.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                user.setRole(cursor.getString(cursor.getColumnIndexOrThrow("role")));
                userList.add(user);
            };
            System.out.println(userList);

            return userList;
        }
        else{
            return null;
        }
        //call searchUser DBHelper
    }
}
