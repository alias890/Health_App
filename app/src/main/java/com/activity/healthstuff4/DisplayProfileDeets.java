package com.activity.healthstuff4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayProfileDeets extends AppCompatActivity {

    userInfo userInfo2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("userInfo");
    List<String> logList;
    ArrayAdapter adapter;
    ListView dailyLogListView;
    Button dailylogButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile_deets);
        dailylogButton = findViewById(R.id.dailylogbtn);
        dailyLogListView = findViewById(R.id.profileList);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                userInfo2 = new userInfo();
                //userInfo2 = new UserInfo(); // same error being thrown saying the object class cannot be instantiated due to it being abstract.

                logList = new ArrayList<>();
                for (DataSnapshot userInfoFromFirebase : snapshot.getChildren())
                {
                    userInfo2 = userInfoFromFirebase.getValue(userInfo.class);
                    logList.add(userInfo2.ToString());

                }

                adapter = new ArrayAdapter(DisplayProfileDeets.this, android.R.layout.simple_list_item_1,logList);
                dailyLogListView.setAdapter(adapter);

                dailylogButton.setOnClickListener(view -> {

                    Intent i = new Intent(DisplayProfileDeets.this, AddDailyLog.class);
                    startActivity(i);
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(DisplayProfileDeets.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
