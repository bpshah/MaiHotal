package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.HotelBookingSystem.Controllers.SearchUserController;
import com.example.HotelBookingSystem.R;

public class SearchUser extends AppCompatActivity {

    EditText lastname;
    Button searchUser;
    Context contxt;
    SearchUserController  cntrl = new SearchUserController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        contxt = this;
        lastname = (EditText)findViewById(R.id.editTextTextPersonName14);
        searchUser = (Button)findViewById(R.id.button14);
        searchUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String lname = String.valueOf(lastname.getText());
                cntrl.searchUser(lname,contxt);
            }
        });
    }
    public void search(View view)
    {
        Intent intent = new Intent(this,UsersList.class);
        startActivity(intent);
    }
}