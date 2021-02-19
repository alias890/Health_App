package com.activity.healthstuff4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DailyLogActivity extends AppCompatActivity {
    UserInfo userInfo2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("userInfo");
    List<String> logList;
    ArrayAdapter adapter;
    ListView dailyLogListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_log);
        dailyLogListView = findViewById(R.id.list);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //userInfo2 = new UserInfo(); // same error being thrown saying the object class cannot be instantiated due to it being abstract.

                logList = new ArrayList<String>();
                for (DataSnapshot userInfoFromFirebase : snapshot.getChildren())
                {
                    userInfo2 = userInfoFromFirebase.getValue(UserInfo.class);
                    logList.add(userInfo2.toString());

                }
                adapter = new ArrayAdapter(DailyLogActivity.this, android.R.layout.simple_list_item_1,logList);

               dailyLogListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(DailyLogActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

