package com.activity.healthstuff4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProfileActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("userInfo");
    public FirebaseStorage storage;
    public StorageReference storagereference;
    userInfo userInfo;
    EditText username, weight,height, calories, goalweight;
    TextView originalweight, height1, gweight;
    Button saveBtn,  imperialBtn;
    Switch imperialswitch;
    String uname,uweight,uheight,ucals,ugoalw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //values
        username = findViewById(R.id.name_et);
        weight = findViewById(R.id.weight_et);
        height = findViewById(R.id.height_et);
        calories = findViewById(R.id.calories_et);
        goalweight = findViewById(R.id.goalweight_et);
        saveBtn = findViewById(R.id.saveprofileBtn);
       // imperialswitch = findViewById(R.id.impSwitch);
        imperialBtn = findViewById(R.id.impBtn);

        imperialBtn.setOnClickListener(new View.OnClickListener() //convert to imperial system
        {
            @Override
            public void onClick(View v)
            {

                 uname = username.getText().toString().trim();
                 uweight = weight.getText().toString().trim();
                 uheight = height.getText().toString().trim();
                 ucals = calories.getText().toString().trim();
                 ugoalw = goalweight.getText().toString().trim();
                double inches = 2.54;
                double pound = 2.205;
                double height2 = Double.parseDouble(uheight);
                double weight2 = Double.parseDouble(uweight);
                double gweight2 = Double.parseDouble(ugoalw);

                double heightAfterCon = height2/inches;
                double weightAfterCon = weight2*pound;
                double gweightAfterCon = gweight2*pound;

                //clears text field:
                weight.setText("");
                height.setText("");
                gweight.setText("");

            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Toast.makeText(ProfileActivity.this, "Data Saved!", Toast.LENGTH_SHORT).show();

                uname = username.getText().toString().trim();
                uweight = weight.getText().toString().trim();
                uheight = height.getText().toString().trim();
                ucals = calories.getText().toString().trim();
                ugoalw = goalweight.getText().toString().trim();
                //adding to object class:
                userInfo = new userInfo(ucals,ugoalw,uheight,uname,uweight);

                myRef.push().setValue(userInfo)
                        .addOnSuccessListener((OnSuccessListener) (aVoid) ->{
                            Toast.makeText(ProfileActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener((e)-> {
                            Toast.makeText(ProfileActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                        });

                Intent i = new Intent(ProfileActivity.this, DisplayProfileDeets.class);//display in Daily Log
                startActivity(i);
            }
        });
    }
}