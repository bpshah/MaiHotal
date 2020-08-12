package com.example.HotelBookingSystem.Controllers;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import com.example.HotelBookingSystem.DatabaseHelper;
import com.example.HotelBookingSystem.Models.Room;
import com.example.HotelBookingSystem.Models.User;

import java.util.ArrayList;

public class SearchforRoomController {
    DatabaseHelper db;
    Room room;
    ArrayList<Room> roomlist;
    public ArrayList<Room> searchforroom(String roomno,String hotel,Context c){
        db = new DatabaseHelper(c);
        Intent intent;
        Cursor cursor = db.searchforroom(roomno,hotel);
        roomlist = new ArrayList<Room>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                room = new Room();
                room.setRoomno(cursor.getInt(cursor.getColumnIndexOrThrow("roomno")));
                room.setRoomprice(cursor.getDouble(cursor.getColumnIndexOrThrow("roomprice")));
                room.setRoomweekendprice(cursor.getDouble(cursor.getColumnIndexOrThrow("roomweekendprice")));
                room.setRoomstatus(cursor.getString(cursor.getColumnIndexOrThrow("roomstatus")));
                room.setHotel(cursor.getString(cursor.getColumnIndexOrThrow("hotel")));
                room.setRoomtype(cursor.getString(cursor.getColumnIndexOrThrow("roomtype")));
                roomlist.add(room);
            }
            System.out.println(roomlist);
            return roomlist;
        }
        else {
            return null;
        }
    }
}
