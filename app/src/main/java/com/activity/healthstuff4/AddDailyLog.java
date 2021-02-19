package com.activity.healthstuff4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AddDailyLog extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("userInfo");
    public FirebaseStorage storage;
    public StorageReference storagereference;
    Button imageBtn, saveBtn;

    EditText addCalories,addMeal,addDate;
    FirebaseAuth mAuth2;
    FirebaseUser currentUser;
    String addCalories2,addMeal2,addDate2;
    DailyLogUpdates DailyLogUpdates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily_log);

        mAuth2 = FirebaseAuth.getInstance();
        saveBtn= findViewById(R.id.dl_saveBtn);
        addCalories = findViewById(R.id.et_calories);
        addDate = findViewById(R.id.et_Date);
        addMeal = findViewById(R.id.et_meal);

        saveBtn.setOnClickListener(view -> {

            addCalories2 = addCalories.getText().toString().trim();
            addDate2 = addDate.getText().toString().trim();
            addMeal2 = addMeal.getText().toString().trim();
            DailyLogUpdates = new DailyLogUpdates(addMeal2,addCalories2,addDate2);

            myRef.push().setValue(DailyLogUpdates)//push to firebase
                    .addOnSuccessListener((OnSuccessListener) (aVoid) -> Toast.makeText(AddDailyLog.this, "Data saved", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener((e)-> {
                        Toast.makeText(AddDailyLog.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
            Intent i = new Intent(AddDailyLog.this, DailyLogActivity.class);//display in Daily Log
            startActivity(i);
        });


    }
}