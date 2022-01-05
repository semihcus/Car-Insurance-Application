package com.example.insuranceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
EditText FirstName, LastName, DOB, ZipCode, PhoneNumber, Username, mPassword;
Button Register2, Login;
FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        DOB = findViewById(R.id.DOB);
        ZipCode = findViewById(R.id.ZipCode);
        PhoneNumber = findViewById(R.id.Phone);
        Username = findViewById(R.id.Email);
        mPassword = findViewById(R.id.Password);
        Register2 = findViewById(R.id.Register2);
        Login = findViewById(R.id.LoginBack);

        fAuth = FirebaseAuth.getInstance();



        Register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = Username.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    Username.setError("Please enter an Email");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    mPassword.setError("Please enter a valid Password");
                    return;
                }

                if(Password.length() < 6){
                    mPassword.setError("Password must be greater than 6 characters");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Successfully Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), NewClaim.class));
                        }else{
                            Toast.makeText(Register.this, "ERROR !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}