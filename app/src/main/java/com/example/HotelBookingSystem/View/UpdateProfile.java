package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.HotelBookingSystem.Controllers.DeleteProfileAdminController;
import com.example.HotelBookingSystem.Controllers.UpdateProfileAdminController;
import com.example.HotelBookingSystem.R;

public class UpdateProfile extends AppCompatActivity {

    EditText fname;
    EditText lname;
    TextView uname;
    EditText phone;
    EditText address;
    EditText email;
    TextView role;
    UpdateProfileAdminController cntrl;
    DeleteProfileAdminController cntrl1;
    Context contxt;

    String firstName;
    String lastName;
    String userName;
    String phoneNo;
    String emailAddr;
    String addr;
    String role_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        contxt = this;

        firstName = (String)getIntent().getSerializableExtra("firstname");
        fname = (EditText)findViewById(R.id.editTextTextPersonName2);
        fname.setText(firstName);

        lastName = (String)getIntent().getSerializableExtra("lastname");
        lname = (EditText) findViewById(R.id.editTextTextPersonName15);
        lname.setText(lastName);

        userName = (String)getIntent().getSerializableExtra("username");
        uname = (TextView)findViewById(R.id.textView71);
        uname.setText(userName);

        phoneNo = (String)getIntent().getSerializableExtra("phone");
        phone = (EditText) findViewById(R.id.editTextNumber2);
        phone.setText(phoneNo);

        emailAddr = (String)getIntent().getSerializableExtra("email");
        email = (EditText) findViewById(R.id.editTextTextPersonName7);
        email.setText(emailAddr);

        addr = (String)getIntent().getSerializableExtra("address");
        address = (EditText)findViewById(R.id.editTextTextPostalAddress3);
        address.setText(addr);

        role_ = (String)getIntent().getSerializableExtra("role");
        role = (TextView)findViewById(R.id.textView114);
        role.setText(role_);

    }
    public void nextPage(View view)
    {
        cntrl = new UpdateProfileAdminController();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation !");
        builder.setMessage("Do you want to update the profile?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cntrl.updateProfileAdmin(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),phone.getText().toString(),
                        address.getText().toString(),uname.getText().toString(),contxt)){
                    Intent intent = new Intent(getApplicationContext(), SearchUser.class);
                    Toast.makeText(getApplicationContext(), "Profile Updated!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), UpdateProfile.class);
                    Toast.makeText(getApplicationContext(), "Unable to Update Profile.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                uname.setText(userName);
                fname.setText(firstName);
                lname.setText(lastName);
                phone.setText(phoneNo);
                email.setText(emailAddr);
                address.setText(addr);
            }
        });

        builder.show();


//        if(cntrl.updateProfileAdmin(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),phone.getText().toString(),
//                address.getText().toString(),uname.getText().toString(),contxt)){
//            Intent intent = new Intent(this, SearchUser.class);
//            Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show();
//            startActivity(intent);
//        }
//        else{
//            Intent intent = new Intent(this, UpdateProfile.class);
//            Toast.makeText(this, "Unable to Update Profile.", Toast.LENGTH_SHORT).show();
//            startActivity(intent);
//
//        }
    }

    public void deleteUser(View view)
    {
        cntrl1 = new DeleteProfileAdminController();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation !");
        builder.setMessage("Do you want to delete the user?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(cntrl1.deleteProfileAdmin(uname.getText().toString(),contxt)){
                    Intent intent = new Intent(getApplicationContext(), SearchUser.class);
                    Toast.makeText(getApplicationContext(), "User Deleted!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), UpdateProfile.class);
                    Toast.makeText(getApplicationContext(), "Unable to delete Profile.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();


//        if(cntrl1.deleteProfileAdmin(uname.getText().toString(),contxt)){
//            Intent intent = new Intent(this, SearchUser.class);
//            Toast.makeText(this, "Profile Deleted!", Toast.LENGTH_SHORT).show();
//            startActivity(intent);
//        }
//        else{
//            Intent intent = new Intent(this, UpdateProfile.class);
//            Toast.makeText(this, "Unable to delete Profile.", Toast.LENGTH_SHORT).show();
//            startActivity(intent);
//        }
    }
}