package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        contxt = this;

        String firstName = (String)getIntent().getSerializableExtra("firstname");
        fname = (EditText)findViewById(R.id.editTextTextPersonName2);
        fname.setText(firstName);

        String lastName = (String)getIntent().getSerializableExtra("lastname");
        lname = (EditText) findViewById(R.id.editTextTextPersonName15);
        lname.setText(lastName);

        String userName = (String)getIntent().getSerializableExtra("username");
        uname = (TextView)findViewById(R.id.textView71);
        uname.setText(userName);

        String phoneNo = (String)getIntent().getSerializableExtra("phone");
        phone = (EditText) findViewById(R.id.editTextNumber2);
        phone.setText(phoneNo);

        String emailAddr = (String)getIntent().getSerializableExtra("email");
        email = (EditText) findViewById(R.id.editTextTextPersonName7);
        email.setText(emailAddr);

        String addr = (String)getIntent().getSerializableExtra("address");
        address = (EditText)findViewById(R.id.editTextTextPostalAddress3);
        address.setText(addr);

        String role_ = (String)getIntent().getSerializableExtra("role");
        role = (TextView)findViewById(R.id.textView114);
        role.setText(role_);

    }
    public void nextPage(View view)
    {
        cntrl = new UpdateProfileAdminController();
        if(cntrl.updateProfileAdmin(fname.getText().toString(),lname.getText().toString(),email.getText().toString(),phone.getText().toString(),
                address.getText().toString(),uname.getText().toString(),contxt)){
            Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, UpdateProfile.class);
            Toast.makeText(this, "Unable to Update Profile.", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }
    }

    public void deleteUser(View view)
    {
        cntrl1 = new DeleteProfileAdminController();
        if(cntrl1.deleteProfileAdmin(uname.getText().toString(),contxt)){
            Intent intent = new Intent(this, SearchUser.class);
            Toast.makeText(this, "Profile Deleted!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this, UpdateProfile.class);
            Toast.makeText(this, "Unable to delete Profile.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
}