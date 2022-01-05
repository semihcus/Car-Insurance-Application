package com.example.insuranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NewClaim extends AppCompatActivity {

    EditText FirstName, LastName, LicenseNumber, VIN;
    Button Submit;
    Firebase DataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_claim);

        FirstName = findViewById(R.id.FirstName2);
        LastName = findViewById(R.id.LastName2);
        LicenseNumber = findViewById(R.id.LicenseNumber);
        VIN = findViewById(R.id.VIN);
        Submit = findViewById(R.id.New);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Firebase.setAndroidContext(this);
        DataBase = new Firebase("https://insurance-app-67edc-default-rtdb.firebaseio.com/Users/");

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase.child("First Name").setValue(FirstName.getText().toString());
                DataBase.child("LastName").setValue(LastName.getText().toString());
                DataBase.child("License Number").setValue(LicenseNumber.getText().toString());
                DataBase.child("VIN").setValue(VIN.getText().toString());
                startActivity(new Intent(getApplicationContext(), InsurancePolicy.class));
            }
        });


    }
}