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

public class MainActivity extends AppCompatActivity {
EditText Username, mPassword;
Button Login, Register;
FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Username = findViewById(R.id.LoginEmail);
    mPassword = findViewById(R.id.PasswordLogin);
    Login = findViewById(R.id.LoginButton);
    fAuth = FirebaseAuth.getInstance();
    Register = findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });



        Login.setOnClickListener(new View.OnClickListener() {
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

            fAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    }else{
                        Toast.makeText(MainActivity.this, "ERROR !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    });


}

}