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
    public void searchUser(String lastname, Context c){
        db = new DatabaseHelper(c);
        Intent intent;
        Cursor cursor = db.searchUser(lastname);
        ArrayList<User> userList = new ArrayList<User>();
        ArrayList<String> firstNameList = new ArrayList<String>();
        ArrayList<String> LastNameList = new ArrayList<String>();
        ArrayList<String> NameList = new ArrayList<String>();
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
                firstNameList.add(user.getFirstname());
            };
            System.out.println(firstNameList);

            // display result
            intent = new Intent(c.getApplicationContext(), UsersList.class);
            //intent.putExtra("userlist", userList);
            intent.putExtra("fnamelist", firstNameList);
            c.startActivity(intent);
        }
        else{
            Toast t = Toast.makeText(c,"No user found with this lastname",Toast.LENGTH_SHORT);
            t.show();
        }
        //call searchUser DBHelper
    }
}
