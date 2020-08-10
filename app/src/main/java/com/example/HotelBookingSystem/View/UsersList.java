package com.example.HotelBookingSystem.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.HotelBookingSystem.Models.User;
import com.example.HotelBookingSystem.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static com.example.HotelBookingSystem.R.id.view_users;

public class UsersList extends AppCompatActivity {

    SearchView searchView;
    Intent intent;
    Context contxt;
    ListView listView;
    ArrayList<User> myListItems;
    ArrayList<HashMap<String,String>> list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist);
        contxt = this;
        list = new ArrayList<>();
        myListItems = (ArrayList<User>) getIntent().getSerializableExtra("usrList");
        listView = (ListView)findViewById(view_users);
       for(int i = 0;i<myListItems.size();i++){
           HashMap item = new HashMap<String,String>();
           item.put("firstname",myListItems.get(i).getFirstname());
           item.put("lastname",myListItems.get(i).getLastname());
           item.put("username",myListItems.get(i).getUsername());
           list.add(item);
       }
        sa = new SimpleAdapter(this, list,
                R.layout.activity_users_list,
                new String[] { "firstname","lastname", "username" },
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c});
       listView.setAdapter(sa);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

       public void onItemClick(AdapterView<?> arg0,View arg1, int position, long arg3)
       {

           Intent n = new Intent(getApplicationContext(), UpdateProfile.class);
           n.putExtra("firstname", myListItems.get(position).getFirstname());
           n.putExtra("lastname", myListItems.get(position).getLastname());
           n.putExtra("username", myListItems.get(position).getUsername());
           n.putExtra("phone", myListItems.get(position).getPhone());
           n.putExtra("address", myListItems.get(position).getAddress());
           n.putExtra("email", myListItems.get(position).getEmail());
           n.putExtra("role", myListItems.get(position).getRole());
           //create xml for view admin profile with update buttuon and delete button
           //implement update profile and delete profile
           //refresh User function on userslist screen for update and delete
           startActivity(n);
       }

    });
}
    public void home(View view){
        intent = new Intent(this, AdminHomeActivity.class);
        contxt.startActivity(intent);

    }

    public void logout(View view)
    {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}