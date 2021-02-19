package com.activity.healthstuff4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText loginemail, loginpassword;
        Button login;
        FirebaseAuth mAuth;
        FirebaseUser currentUser;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        loginemail = findViewById(R.id.Loginemail_et);
        loginpassword = findViewById(R.id.Loginpassword_et);
        currentUser = mAuth.getCurrentUser();
        login = findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String enteredEmail =loginemail.getText().toString().trim();
                String enteredPassword = loginpassword.getText().toString().trim();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

                mAuth.signInWithEmailAndPassword(enteredEmail, enteredPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())

                        {
                          //  cardview_userlogin.setVisibility(View.GONE);

                            Toast.makeText(LoginActivity.this, "Logged In" + " " + mAuth.getCurrentUser().getEmail() + " " + "Successfully", Toast.LENGTH_SHORT).show();



                        }

                        else
                        {
                            Toast.makeText(LoginActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();


                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();

        //   FirebaseUser currentuser = mAuth.getCurrentUser();
        //  Toast.makeText(this, "Welcome :)"+ currentuser.getEmail(), Toast.LENGTH_SHORT).show();

    }
}