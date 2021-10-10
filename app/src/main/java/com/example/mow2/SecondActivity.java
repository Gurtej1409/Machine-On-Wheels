package com.example.mow2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.mow2.databinding.ActivitySecondBinding;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.bike1,R.drawable.bike2,R.drawable.bike3,R.drawable.bike4,R.drawable.bmw};

        String[] name = {"Ducati MultiStrada","Ducati Panigale","Kawasaki H2","Ducati StreetFighter","BMW S1000RR"};
        String[] lastMessage = {"Adventure Tourer","SuperSports","SportsTourer","NakedSports","SuperSports",};
        String[] lastmsgTime = {"1000cc","1000cc","1200cc","999cc","1000cc"};
        String[] phoneNo = {"20lakh","20lakh","20lakh","20lakh","20lakh"};
        String[] country = {"Infinity","Infinity","Azen","Infinity","Bmw"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],lastMessage[i],lastmsgTime[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);

        }

        ListAdapter listAdapter = new ListAdapter(SecondActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(SecondActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageId",imageId[position]);
                startActivity(i);






            }
        });



        }



    }
