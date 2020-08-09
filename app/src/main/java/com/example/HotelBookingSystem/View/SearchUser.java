package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.example.HotelBookingSystem.Controllers.SearchUserController;
import com.example.HotelBookingSystem.Models.User;
import com.example.HotelBookingSystem.R;

import java.util.ArrayList;

public class SearchUser extends AppCompatActivity {

    EditText lastname;
    Button searchUser;
    Context contxt;
    Intent intent;
    SearchUserController  cntrl = new SearchUserController();
    ArrayList<User> users = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        contxt = this;

        lastname = (EditText)findViewById(R.id.editTextTextPersonName14);
        searchUser = (Button)findViewById(R.id.button14);

    }

    public void search(View view)
    {
        final String lname = String.valueOf(lastname.getText());
        users = cntrl.searchUser(lname,contxt);

        if(users == null){
            Toast t = Toast.makeText(contxt,"No user found with this lastname",Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            intent = new Intent(this, UsersList.class);
            intent.putExtra("usrList",users);
            contxt.startActivity(intent);
        }

    }
}