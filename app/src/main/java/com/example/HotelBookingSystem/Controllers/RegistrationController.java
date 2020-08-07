package com.example.HotelBookingSystem.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.HotelBookingSystem.DatabaseHelper;
import com.example.HotelBookingSystem.View.MainActivity;
import com.example.HotelBookingSystem.View.Registration;
import com.example.HotelBookingSystem.View.UserHomeActivity;

public class RegistrationController {
    boolean user;
    DatabaseHelper db;
    public boolean register(String username, String password, String firstname, String lastname, String phone, String address, String email, String cardType,
                            String cardNumber, String cardExpiryDate, Context c){

        // if true call insert user from dabhelper
        db = new DatabaseHelper(c);
        Intent intent;
        if(!db.checkUserExist(username,password)){
                ContentValues contentValues = new ContentValues();
                contentValues.put("username",username);
                contentValues.put("password",password);
                contentValues.put("firstname",firstname);
                contentValues.put("lastname",lastname);
                contentValues.put("phone",phone);
                contentValues.put("address",address);
                contentValues.put("email",email);
                contentValues.put("cardType",cardType);
                contentValues.put("cardNumber",cardNumber);
                contentValues.put("expiryDate",cardExpiryDate);
                contentValues.put("role","Guest");

            db.insertUser(contentValues);
            intent = new Intent(c.getApplicationContext(), MainActivity.class);
            c.startActivity(intent);
            Toast t = Toast.makeText(c,"Registration Successfully",Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            Toast t = Toast.makeText(c,"You are already registered",Toast.LENGTH_SHORT);
            t.show();
        }
        return user;
    }
}
