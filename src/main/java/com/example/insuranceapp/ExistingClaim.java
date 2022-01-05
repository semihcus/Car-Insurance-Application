package com.example.insuranceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExistingClaim extends AppCompatActivity {

    Button MainMenu, Retrieve;
    FirebaseDatabase DataBase;
    DatabaseReference mRef;
    TextView Policy;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private ArrayList<String> Info = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_claim);

        Retrieve = findViewById(R.id.Retrieve);


       Retrieve.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mRef.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot snapshot) {
                       DataBase = FirebaseDatabase.getInstance();
                       mRef = DataBase.getReference("Policies");

                       String PolicyV = snapshot.child("Policy").getValue().toString();
                       Policy.setText(PolicyV);

                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError error) {

                   }
               });
           }
       });

        MainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
            }
        });

    }

}