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
    ArrayList<String> rooms = new ArrayList<>();
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

    public ArrayList<Room> roomsearch(String checkindate_, String checkoutdate_, String noofroom_, String roomtype_, Context contxt) {
        db = new DatabaseHelper(contxt);
        Intent intent;
        Cursor cursor = db.roomsearch(noofroom_,roomtype_);
        ArrayList<Room> rooms = new ArrayList<Room>();
        Room r = new Room();
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                r = new Room();
                r.setHotel(cursor.getString(cursor.getColumnIndexOrThrow("hotel")));
                r.setHotel(cursor.getString(cursor.getColumnIndexOrThrow("roomtype")));
            }
            return rooms;
        }
        else{
            return null;
        }
    }
}
