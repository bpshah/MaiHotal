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

    String createTableUser = "CREATE TABLE IF NOT EXISTS user ( username TEXT PRIMARY KEY," +
            "password TEXT NOT NULL," +
            "firstname TEXT NOT NULL," +
            "lastname TEXT NOT NULL," +
            "phone TEXT NOT NULL," +
            "address TEXT NOT NULL," +
            "email TEXT NOT NULL UNIQUE," +
            "cardType TEXT NOT NULL," +
            "cardNumber TEXT NOT NULL," +
            "expiryDate TEXT NOT NULL,"+
            "role NOT NULL)";

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists user");
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
}
