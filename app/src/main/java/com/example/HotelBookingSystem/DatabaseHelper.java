package com.example.HotelBookingSystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HotelManagement.db";
    private static final int DATABASE_VERSION = 1;
    private final Context context;
    private static SQLiteDatabase db;

    //private static final String DATABASE_PATH = "/Users/kavanmehta/AndroidStudioProjects/MaiHotal/app/src/main/assets/";
    private final String USER_TABLE = "user";
    private final String ROOM_TABLE = "room";

    String createTableUser = "CREATE TABLE IF NOT EXISTS user ( username TEXT PRIMARY KEY," +
            "password TEXT NOT NULL," +
            "firstname TEXT NOT NULL," +
            "lastname TEXT NOT NULL," +
            "phone TEXT NOT NULL," +
            "address TEXT NOT NULL," +
            "email TEXT NOT NULL UNIQUE," +
            "cardType TEXT," +
            "cardNumber TEXT," +
            "expiryDate TEXT,"+
            "role TEXT NOT NULL)";

    String createTableRoom = "CREATE TABLE IF NOT EXISTS room ( roomno INT NOT NULL," +
            "roomprice DOUBLE NOT NULL," +
            "roomweekendprice DOUBLE NOT NULL," +
            "roomstatus TEXT NOT NULL," +
            "roomtype TEXT NOT NULL," +
            "hotel TEXT NOT NULL)";

    String addManager = "insert into user( username,password,firstname,lastname,phone,address,email,cardType,cardNumber,expiryDate,role) values " +
            "('SammyJ','Password12$','Sam','Johnson','8177772000','1234 Anywhere Ln. Arlington TX 76019','sammyj@mavs.uta.edu','','','','HotelManager')";
    String addAdmin = "insert into user( username,password,firstname,lastname,phone,address,email,cardType,cardNumber,expiryDate,role) values" +
            " ('SuzieQ','Password$34','Susan','Queen','8177772345','5678 Straight Dr. Arlington TX 76019','SuzieQ@mavs.uta.edu','','','','Admin')";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        getWritableDatabase().execSQL(createTableUser);
        db = this.getReadableDatabase();
    }

    public void insertUser(ContentValues contentValues)
    {
        getWritableDatabase().insert("user",null,contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableUser);
        db.execSQL(addManager);
        db.execSQL(addAdmin);
        db.execSQL(createTableRoom);
        int i=1;
        for(i=1;i<101;i++) {
            if(i < 89) {
                String addRoom1 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",100,150,'Available','Standard','Maverick')";
                String addRoom2 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",100,150,'Available','Standard','Ranger')";
                String addRoom3 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",100,150,'Available','Standard','Williams')";
                String addRoom4 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",100,150,'Available','Standard','Shard')";
                String addRoom5 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",100,150,'Available','Standard','Liberty')";
                db.execSQL(addRoom1);
                db.execSQL(addRoom2);
                db.execSQL(addRoom3);
                db.execSQL(addRoom4);
                db.execSQL(addRoom5);
            }
            else if(i<97) {
                String addRoom1 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",135,185,'Available','Deluxe','Maverick')";
                String addRoom2 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",135,185,'Available','Deluxe','Ranger')";
                String addRoom3 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",135,185,'Available','Deluxe','Williams')";
                String addRoom4 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",135,185,'Available','Deluxe','Shard')";
                String addRoom5 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",135,185,'Available','Deluxe','Liberty')";
                db.execSQL(addRoom1);
                db.execSQL(addRoom2);
                db.execSQL(addRoom3);
                db.execSQL(addRoom4);
                db.execSQL(addRoom5);
            }
            else{
                String addRoom1 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",225,275,'Available','Suite','Maverick')";
                String addRoom2 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",225,275,'Available','Suite','Ranger')";
                String addRoom3 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",225,275,'Available','Suite','Williams')";
                String addRoom4 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",225,275,'Available','Suite','Shard')";
                String addRoom5 = "insert into room(roomno,roomprice,roomweekendprice,roomstatus,roomtype,hotel) values("+i+",225,275,'Available','Suite','Liberty')";
                db.execSQL(addRoom1);
                db.execSQL(addRoom2);
                db.execSQL(addRoom3);
                db.execSQL(addRoom4);
                db.execSQL(addRoom5);
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists user");
        db.execSQL("DROP TABLE IF EXISTS room");
        onCreate(db);

    }

    public boolean checkUserExist(String username, String password){
        //onUpgrade(db,1,1);
        String[] columns = {"username"};
        //db = openDb();
        db = this.getWritableDatabase();
        System.out.println("True: "+db.isOpen());

        String sql = "SELECT username,password FROM user WHERE username = '"+username+"' and password = '"+password+"'";

        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        cursor.close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }

    public Cursor login(String username,String password){
        String query = "SELECT role FROM user WHERE username = '"+username+"'AND password = '"+password+"'";
        return db.rawQuery(query,null);
    }

    public Cursor searchUser(String lastname){
//        String query = "select * from user where lastname = '"+lastname+"' and role='Guest' and role='HotelManager'";
        String query = "select * from user where lastname = '"+lastname+"'";

        return db.rawQuery(query,null);
    }

    public boolean updateProfileAdmin(String fname,String lname,String email,String phone,String addr,String uname){
        String query = "Update user set firstname = '"+fname+"', lastname = '"+lname+"', phone = '"+phone+"', address = '"+addr+
                "', email = '"+email+"' where username = '"+uname+"';";
        db.execSQL(query);
        return true;
    }

    public boolean deleteProfileAdmin(String uname){
        String query = "delete from user where username= '"+uname+"'";
        db.execSQL(query);
        return true;
    }

    public Cursor getProfile(String username){
        String query = "select * from user where username ='"+username+"'";
        System.out.println("Query: "+query);
        return db.rawQuery(query,null);
    }

    public boolean updateProfile(String fname,String lname,String email,String phone,String addr,String uname,
                                 String ccnum,String cctype,String ccdate,String pwd){
        String query = "Update user set firstname = '"+fname+"', lastname = '"+lname+"', phone = '"+phone+"', address = '"+addr+
                "', email = '"+email+"',password = '"+pwd+"', cardNumber = '"+ccnum+"',cardType = '"+cctype+"',expiryDate = '"+ccdate+"'" +
                " where username = '"+uname+"';";
        db.execSQL(query);
        return true;
    }

    public Cursor searchforroom(String roomno,String hotelName){
        String query = "select * from room where roomno ='"+roomno+"' and hotel = '"+hotelName+"'";
        return db.rawQuery(query,null);
    }

    public boolean saveRoom(String rtype, double weekdayprice, double weekendprice, String avail, String hotel, int roomno){
        String query = "update room set roomtype= '"+rtype+"', roomprice = "+weekdayprice+", roomweekendprice ="+weekendprice+
                ", roomstatus = '"+avail+"' where hotel = '"+hotel+"' and roomno = "+roomno;
        db.execSQL(query);
        return true;
    }

}
