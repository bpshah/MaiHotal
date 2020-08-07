package com.example.HotelBookingSystem.View;

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

import com.example.HotelBookingSystem.Controllers.LoginController;
import com.example.HotelBookingSystem.R;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;
    Button signupButton;
    Context contxt;
    LoginController lgin = new LoginController();
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
        signupButton = (Button) findViewById(R.id.signup);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final String _username_ = String.valueOf(username.getText());
                final String _password_ = String.valueOf(password.getText());

            if(!lgin.login(_username_,_password_,contxt)){
                password.setText(null);
                Toast.makeText(contxt, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }

    public void changePage(View view){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }
}