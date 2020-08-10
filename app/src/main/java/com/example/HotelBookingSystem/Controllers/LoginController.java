package com.example.HotelBookingSystem.Controllers;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.Toast;

import com.example.HotelBookingSystem.DatabaseHelper;
import com.example.HotelBookingSystem.View.AdminHomeActivity;
import com.example.HotelBookingSystem.View.MainActivity;
import com.example.HotelBookingSystem.View.ManagerHomeActivity;
import com.example.HotelBookingSystem.View.UserHomeActivity;

public class LoginController {
    DatabaseHelper db;
    public boolean login(String username,String password, Context c){
        db = new DatabaseHelper(c);
        Cursor cursor = db.login(username,password);
        //System.out.println(cursor.getCount());
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            Intent intent;
            if(cursor.getString(cursor.getColumnIndexOrThrow("role")).equals("Guest")){
                intent = new Intent(c.getApplicationContext(), UserHomeActivity.class);
                intent.putExtra("uniquename",username);
            }
            else if(cursor.getString(cursor.getColumnIndexOrThrow("role")).equals("HotelManager")){
                intent = new Intent(c.getApplicationContext(), ManagerHomeActivity.class);
                intent.putExtra("uniquename",username);
            }
            else{
                intent = new Intent(c.getApplicationContext(), AdminHomeActivity.class);
                intent.putExtra("uniquename",username);
            }
            //Intent intent = new Intent(MainActivity.this, UserHomeActivity.class);
            c.startActivity(intent);
            return true;
        }
        else {
            return false;
        }

    }
}
