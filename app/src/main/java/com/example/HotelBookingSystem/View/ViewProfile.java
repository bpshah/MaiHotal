package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.HotelBookingSystem.Controllers.UpdateProfileController;
import com.example.HotelBookingSystem.Controllers.ViewProfileController;
import com.example.HotelBookingSystem.R;

public class ViewProfile extends AppCompatActivity {

    TextView uname;
    EditText pwd;
    EditText fname;
    EditText lname;
    EditText phone;
    EditText email;
    EditText addr;
    EditText ccnum;
    EditText cctype;
    EditText ccdate;
    TextView role;

    ViewProfileController cntrl;
    Context contxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        contxt = this;
        cntrl = new ViewProfileController();
        String username = getIntent().getStringExtra("userID");
        System.out.println("Username"+username);
        Cursor cursor = cntrl.getProfile(username,contxt);
        System.out.println("True:"+cursor.moveToFirst());
        cursor.moveToFirst();

        uname = (TextView)findViewById(R.id.textView17);
        uname.setText(cursor.getString(cursor.getColumnIndexOrThrow("username")));

        pwd = (EditText)findViewById(R.id.editTextTextPassword2);
        pwd.setText(cursor.getString(cursor.getColumnIndexOrThrow("password")));

        fname = (EditText)findViewById(R.id.editTextTextPersonName);
        fname.setText(cursor.getString(cursor.getColumnIndexOrThrow("firstname")));

        lname = (EditText)findViewById(R.id.editTextTextPersonName4);
        lname.setText(cursor.getString(cursor.getColumnIndexOrThrow("lastname")));

        phone = (EditText)findViewById(R.id.editTextPhone);
        phone.setText(cursor.getString(cursor.getColumnIndexOrThrow("phone")));

        email = (EditText)findViewById(R.id.editTextTextEmailAddress2);
        email.setText(cursor.getString(cursor.getColumnIndexOrThrow("email")));

        addr = (EditText)findViewById(R.id.editTextTextPostalAddress);
        addr.setText(cursor.getString(cursor.getColumnIndexOrThrow("address")));

        ccnum = (EditText)findViewById(R.id.editTextTextPersonName17);
        ccnum.setText(cursor.getString(cursor.getColumnIndexOrThrow("cardNumber")));

        cctype = (EditText)findViewById(R.id.editTextTextPersonName5);
        cctype.setText(cursor.getString(cursor.getColumnIndexOrThrow("cardType")));

        ccdate = (EditText)findViewById(R.id.editTextDate);
        ccdate.setText(cursor.getString(cursor.getColumnIndexOrThrow("expiryDate")));

        role = (TextView)findViewById(R.id.textView12);
        role.setText(cursor.getString(cursor.getColumnIndexOrThrow("role")));

        if(role.getText().equals("Admin")){
            pwd.setEnabled(false);
            fname.setEnabled(false);
            lname.setEnabled(false);
            phone.setEnabled(false);
            addr.setEnabled(false);
            email.setEnabled(false);
            ccnum.setEnabled(false);
            cctype.setEnabled(false);
            ccdate.setEnabled(false);
        }
        else if(role.getText().equals("HotelManager")){
            ccnum.setEnabled(false);
            cctype.setEnabled(false);
            ccdate.setEnabled(false);
        }

    }
    public void saveProfile(View view)
    {
        UpdateProfileController cntrl1 = new UpdateProfileController();
        if(cntrl1.updateProfile(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),phone.getText().toString(),
                addr.getText().toString(),uname.getText().toString(),ccnum.getText().toString(),cctype.getText().toString(),ccdate.getText().toString(),
                pwd.getText().toString(),contxt)){
            Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Unable to Update Profile.", Toast.LENGTH_SHORT).show();

        }
    }
}