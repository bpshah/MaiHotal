package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.HotelBookingSystem.R;
import com.example.HotelBookingSystem.Controllers.RegistrationController;

import com.example.HotelBookingSystem.Controllers.RegistrationController;

public class Registration extends AppCompatActivity {

    EditText userName;
    EditText password;
    EditText cpassword;
    EditText firstName;
    EditText lastName;
    EditText phone;
    EditText email;
    EditText address;
    EditText cardType;
    EditText cardNumber;
    EditText expiryDate;
    Button register;
    Context contxt;
    RegistrationController cntrl = new RegistrationController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        cardType = findViewById(R.id.cardtype);
        cardNumber = findViewById(R.id.cardnumber);
        expiryDate = findViewById(R.id.expirydate);
        register = findViewById(R.id.register);

        contxt = this;

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkDataEntered();
                String usernameValue = userName.getText().toString();
                String passwordValue = password.getText().toString();
                String firstNameValue = firstName.getText().toString();
                String lastNameValue = lastName.getText().toString();
                String phoneValue = phone.getText().toString();
                String addressValue  = address.getText().toString();
                String emailValue = email.getText().toString();
                String cardTypeValue = cardType.getText().toString();
                String cardNumberValue = cardNumber.getText().toString();
                String expiryDateValue = expiryDate.getText().toString();

                // call register from registration controller
                cntrl.register(usernameValue,passwordValue,firstNameValue,lastNameValue,phoneValue,addressValue,
                        emailValue,cardTypeValue,cardNumberValue,expiryDateValue,contxt);

//                ContentValues contentValues = new ContentValues();
//                contentValues.put("username",usernameValue);
//                contentValues.put("password",passwordValue);
//                contentValues.put("first_name",firstNameValue);
//                contentValues.put("last_name",lastNameValue);
//                contentValues.put("Phone",phoneValue);
//                contentValues.put("email",emailValue);
//                contentValues.put("address",addressValue);
//                contentValues.put("card_type",cardTypeValue);
//                contentValues.put("card_number",cardNumberValue);
//                contentValues.put("expiry_date",expiryDateValue);

            }
        });
    }

    boolean isEmpty(EditText text)
    {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    public void checkDataEntered()
    {
        if(isEmpty(userName))
        {
            Toast t = Toast.makeText(this,"You must enter first name to register!",Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(password))
        {
            Toast t = Toast.makeText(this,"You must enter password to register!",Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(firstName))
        {
            Toast t = Toast.makeText(this,"You must enter first name to register!",Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(phone))
        {
            Toast t = Toast.makeText(this,"You must enter phone to register!",Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(address))
        {
            Toast t = Toast.makeText(this,"You must enter address to register!",Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(email))
        {
            Toast t = Toast.makeText(this,"You must enter email to register!",Toast.LENGTH_SHORT);
            t.show();
        }
        else
        {
            if(isEmail(email))
            {
                email.setError("Enter a valid email!");
            }
        }
        if(isEmpty(cardType))
        {
            Toast t = Toast.makeText(this,"You must enter card type to register!",Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(cardNumber))
        {
            Toast t = Toast.makeText(this,"You must enter cardNumber to register!",Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(expiryDate))
        {
            Toast t = Toast.makeText(this,"You must enter expiry date to register!",Toast.LENGTH_SHORT);
            t.show();
        }
    }
    boolean isEmail(EditText text)
    {
        CharSequence email = text.getText().toString();
        return(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean checkPassword(EditText password, EditText cpassword)
    {
        CharSequence pass = password.getText().toString();
        CharSequence cpass = cpassword.getText().toString();
        boolean result = false;
        if(pass == cpass)
        {
            result = true;
            return result;
        }
        else {
            result = false;
            return result;
        }
    }
    public void backToHomePage(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        Toast.makeText(this, "Registered Successfully!!.", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}