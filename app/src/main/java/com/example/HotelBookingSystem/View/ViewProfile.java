package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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

    String uname_;
    String pwd_;
    String fname_;
    String lname_;
    String phone_;
    String email_;
    String addr_;
    String ccnum_;
    String cctype_;
    String ccdate_;
    String role_;


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

        Toast.makeText(getApplicationContext(), "Profile Updated!", Toast.LENGTH_LONG).show();

        uname = (TextView)findViewById(R.id.textView17);
        uname.setText(cursor.getString(cursor.getColumnIndexOrThrow("username")));
        uname_ = cursor.getString(cursor.getColumnIndexOrThrow("username"));

        pwd = (EditText)findViewById(R.id.editTextTextPassword2);
        pwd.setText(cursor.getString(cursor.getColumnIndexOrThrow("password")));
        pwd_ = cursor.getString(cursor.getColumnIndexOrThrow("password"));

        fname = (EditText)findViewById(R.id.editTextTextPersonName);
        fname.setText(cursor.getString(cursor.getColumnIndexOrThrow("firstname")));
        fname_ = cursor.getString(cursor.getColumnIndexOrThrow("firstname"));

        lname = (EditText)findViewById(R.id.editTextTextPersonName4);
        lname.setText(cursor.getString(cursor.getColumnIndexOrThrow("lastname")));
        lname_ = cursor.getString(cursor.getColumnIndexOrThrow("lastname"));

        phone = (EditText)findViewById(R.id.editTextPhone);
        phone.setText(cursor.getString(cursor.getColumnIndexOrThrow("phone")));
        phone_ = cursor.getString(cursor.getColumnIndexOrThrow("phone"));

        email = (EditText)findViewById(R.id.editTextTextEmailAddress2);
        email.setText(cursor.getString(cursor.getColumnIndexOrThrow("email")));
        email_ = cursor.getString(cursor.getColumnIndexOrThrow("email"));

        addr = (EditText)findViewById(R.id.editTextTextPostalAddress);
        addr.setText(cursor.getString(cursor.getColumnIndexOrThrow("address")));
        addr_ = cursor.getString(cursor.getColumnIndexOrThrow("address"));

        ccnum = (EditText)findViewById(R.id.editTextTextPersonName17);
        ccnum.setText(cursor.getString(cursor.getColumnIndexOrThrow("cardNumber")));
        ccnum_ = cursor.getString(cursor.getColumnIndexOrThrow("cardNumber"));

        cctype = (EditText)findViewById(R.id.editTextTextPersonName5);
        cctype.setText(cursor.getString(cursor.getColumnIndexOrThrow("cardType")));
        cctype_ = cursor.getString(cursor.getColumnIndexOrThrow("cardType"));

        ccdate = (EditText)findViewById(R.id.editTextDate);
        ccdate.setText(cursor.getString(cursor.getColumnIndexOrThrow("expiryDate")));
        ccdate_ = cursor.getString(cursor.getColumnIndexOrThrow("expiryDate"));

        role = (TextView)findViewById(R.id.textView12);
        role.setText(cursor.getString(cursor.getColumnIndexOrThrow("role")));
        role_ = cursor.getString(cursor.getColumnIndexOrThrow("role"));

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
        final UpdateProfileController cntrl1 = new UpdateProfileController();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation !");
        builder.setMessage("Do you want to update the profile?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cntrl1.updateProfile(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),phone.getText().toString(),
                        addr.getText().toString(),uname.getText().toString(),ccnum.getText().toString(),cctype.getText().toString(),ccdate.getText().toString(),
                        pwd.getText().toString(),contxt)){
                        Toast.makeText(getApplicationContext(), "Profile Updated!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Unable to update Profile!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                uname.setText(uname_);
                fname.setText(fname_);
                lname.setText(lname_);
                pwd.setText(pwd_);
                phone.setText(phone_);
                email.setText(email_);
                addr.setText(addr_);
                ccnum.setText(ccnum_);
                cctype.setText(cctype_);
                ccdate.setText(ccdate_);
            }
        });

        builder.show();
//        if(cntrl1.updateProfile(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),phone.getText().toString(),
//                addr.getText().toString(),uname.getText().toString(),ccnum.getText().toString(),cctype.getText().toString(),ccdate.getText().toString(),
//                pwd.getText().toString(),contxt)){
//            Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(this, "Unable to Update Profile.", Toast.LENGTH_SHORT).show();
//
//        }
    }
}