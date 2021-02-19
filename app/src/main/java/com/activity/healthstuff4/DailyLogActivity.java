package com.activity.healthstuff4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    userInfo userInfo2;
    DailyLogUpdates dailyLogUpdates;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("userInfo");
    List<String> ddList;
    ArrayAdapter adapter;
    ListView diaryListView;
    Button graphbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_log);

       diaryListView = findViewById(R.id.dailyloglist);
        graphbtn = findViewById(R.id.viewgraphBtn);

        graphbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DailyLogActivity.this, GraphActivity.class);
                startActivity(i);
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                dailyLogUpdates = new DailyLogUpdates();

                ddList = new ArrayList<String>();
                for (DataSnapshot userInfoFromFirebase : snapshot.getChildren())
                {
                    dailyLogUpdates = userInfoFromFirebase.getValue(DailyLogUpdates.class);

                    ddList.add(dailyLogUpdates.toString());
                }
                adapter = new ArrayAdapter(DailyLogActivity.this, android.R.layout.simple_list_item_1,ddList);

               diaryListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(DailyLogActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

