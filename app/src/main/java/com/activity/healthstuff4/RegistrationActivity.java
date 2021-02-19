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

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText email, password;
        Button login, register;
        FirebaseAuth mAuth;
        FirebaseUser currentUser;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

       mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_et);
        password = findViewById(R.id.password_et);
         login = findViewById(R.id.loginUserBtn);
        register = findViewById(R.id.registerUserBtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String enterEmail = email.getText().toString().trim();
                String enterPassword = password.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(enterEmail, enterPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(RegistrationActivity.this, "User"+mAuth.getCurrentUser().getEmail()+"is  registered", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(RegistrationActivity.this, "Unsuccessful registration.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(RegistrationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String enteredEmail = email.getText().toString().trim();
                String enteredPassword = email.getText().toString().trim();
                Intent intent = new Intent(RegistrationActivity.this, ProfileActivity.class);
                startActivity(intent);

                mAuth.signInWithEmailAndPassword(enteredEmail, enteredPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())

                        {
                           // loginCardView.setVisibility(View.GONE);

                            Toast.makeText(RegistrationActivity.this, "Logged In" + " " + mAuth.getCurrentUser().getEmail() + " " + "Successfully", Toast.LENGTH_SHORT).show();

                        }

                        else
                        {
                            Toast.makeText(RegistrationActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();

                        }


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        Toast.makeText(RegistrationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

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