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
    SQLiteDatabase db;

    //private static final String DATABASE_PATH = "/Users/kavanmehta/AndroidStudioProjects/MaiHotal/app/src/main/assets/";
    private final String USER_TABLE = "users";

    String createTableUser = "CREATE TABLE \\\"users\\\" (\\n\" +\n" +
            "                \"\\t\\\"username\\\"\\tTEXT NOT NULL,\\n\" +\n" +
            "                \"\\t\\\"password\\\"\\tTEXT NOT NULL,\\n\" +\n" +
            "                \"\\t\\\"first_name\\\"\\tTEXT NOT NULL,\\n\" +\n" +
            "                \"\\t\\\"last_name\\\"\\tTEXT,\\n\" +\n" +
            "                \"\\t\\\"Phone\\\"\\tNUMERIC,\\n\" +\n" +
            "                \"\\t\\\"email\\\"\\tTEXT UNIQUE,\\n\" +\n" +
            "                \"\\t\\\"street_number\\\"\\tTEXT,\\n\" +\n" +
            "                \"\\t\\\"street_name\\\"\\tTEXT,\\n\" +\n" +
            "                \"\\t\\\"city\\\"\\tTEXT,\\n\" +\n" +
            "                \"\\t\\\"state\\\"\\tTEXT,\\n\" +\n" +
            "                \"\\t\\\"zip_code\\\"\\tNUMERIC,\\n\" +\n" +
            "                \"\\t\\\"card_type\\\"\\tTEXT,\\n\" +\n" +
            "                \"\\t\\\"card_number\\\"\\tNUMERIC,\\n\" +\n" +
            "                \"\\t\\\"role\\\"\\tTEXT DEFAULT 'Guest',\\n\" +\n" +
            "                \"\\tPRIMARY KEY(\\\"username\\\")\\n\" +\n" +
            "                \");";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        getWritableDatabase().execSQL(createTableUser);
        db = this.getReadableDatabase();
    }

    public void insertUser(ContentValues contentValues)
    {
        getWritableDatabase().insert("user","",contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"users\" (\n" +
                "\t\"username\"\tTEXT NOT NULL,\n" +
                "\t\"password\"\tTEXT NOT NULL,\n" +
                "\t\"first_name\"\tTEXT NOT NULL,\n" +
                "\t\"last_name\"\tTEXT,\n" +
                "\t\"Phone\"\tNUMERIC,\n" +
                "\t\"email\"\tTEXT UNIQUE,\n" +
                "\t\"address\"\tTEXT,\n" +
                "\t\"card_type\"\tTEXT,\n" +
                "\t\"card_number\"\tNUMERIC,\n" +
                "\t\"expiry_date\"\tTEXT NOT NULL,\n" +
                "\t\"role\"\tTEXT DEFAULT 'Guest',\n" +
                "\tPRIMARY KEY(\"username\")\n" +
                ");");
        db.execSQL("INSERT INTO users VALUES ('kavan','kavan123','Kavan','Mehta',6463311689,'kavanrd@gmail.com','417','Summit Ave','Arlington','Texas',76013,'Visa',1234567812345678,'Guest')");
        db.execSQL("INSERT INTO users VALUES ('kavan1','kavan456','Kavan','Mehta',6463311689,'kavanre@gmail.com','417','Summit Ave','Arlington','Texas',76013,'Visa',1234567812345678,'Manager')");
        db.execSQL("INSERT INTO users VALUES ('kavan2','kavan789','Kavan','Mehta',6463311689,'kavanrf@gmail.com','417','Summit Ave','Arlington','Texas',76013,'Visa',1234567812345678,'Admin')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists users");
        onCreate(db);

    }


    public boolean checkUserExist(String username, String password){
        //onUpgrade(db,1,1);
        String[] columns = {"username"};
        //db = openDb();
        db = this.getWritableDatabase();
        System.out.println("True: "+db.isOpen());

        System.out.println("SELECT username,password FROM users WHERE username = '"+username+"' and password = '"+password+"'");

        Cursor cursor = db.rawQuery("SELECT * FROM users",null);
        cursor.moveToFirst();
        int count = cursor.getCount();

        cursor.close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
}
