package com.example.HotelBookingSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    Context contxt;
    com.example.HotelBookingSystem.DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new com.example.HotelBookingSystem.DatabaseHelper(this);
        final SQLiteDatabase db1 = this.openOrCreateDatabase("HotelManagement.db",MODE_PRIVATE,null);

        contxt = this;

        username = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText)findViewById(R.id.editTextTextPassword);
        loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final String _username_ = String.valueOf(username.getText());
                final String _password_ = String.valueOf(password.getText());


                String query = "SELECT role FROM users WHERE username = '"+_username_+"'AND password = '"+_password_+"'";
                Cursor cursor = db1.rawQuery(query,null);
                System.out.println(cursor.getCount());
                if(cursor.getCount() > 0)
                {
                    cursor.moveToFirst();
                    Intent intent;
                    if(cursor.getString(cursor.getColumnIndexOrThrow("role")).equals("Guest")){
                        intent = new Intent(MainActivity.this, com.example.HotelBookingSystem.UserHomeActivity.class);
                    }
                    else if(cursor.getString(cursor.getColumnIndexOrThrow("role")).equals("Manager")){
                        intent = new Intent(MainActivity.this, com.example.HotelBookingSystem.ManagerHomeActivity.class);
                    }
                    else{
                        intent = new Intent(MainActivity.this, com.example.HotelBookingSystem.AdminHomeActivity.class);
                    }
                    //Intent intent = new Intent(MainActivity.this, UserHomeActivity.class);
                    startActivity(intent);
                }
                else {
                    password.setText(null);
                    Toast.makeText(MainActivity.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void changePage(View view){
        Intent intent = new Intent(this, com.example.HotelBookingSystem.FinalPayment.class);
        startActivity(intent);
    }
}