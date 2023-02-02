package com.example.chalaan.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.chalaan.CardView1;
import com.example.chalaan.OCR;
import com.example.chalaan.R;
import com.example.chalaan.Rules;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PoliceLogin extends AppCompatActivity {

    private EditText userMail,userPassword;
    private Button btnLogin;
    private ProgressBar loginProgress;
    private ImageView loginPhoto;
    private DatabaseReference ref;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_login);
        userMail = findViewById(R.id.login_mail);
        userPassword = findViewById(R.id.login_password);
        btnLogin =findViewById(R.id.loginBtn);
        loginProgress =findViewById(R.id.login_progress);
        loginPhoto =findViewById(R.id.login_photo);
        ref = FirebaseDatabase.getInstance().getReference().child("Police");

        loginPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerActivity = new Intent(getApplicationContext(), PoliceReg.class);
                startActivity(registerActivity);
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=userMail.getText().toString();
                final String password = userPassword.getText().toString();
                try {
                    ref.child(email).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Police police = dataSnapshot.getValue(Police.class);
                            if (password.equals(police.getPassword())) {
                                Toast.makeText(PoliceLogin.this, "Login sucessfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(PoliceLogin.this, CardView1.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(PoliceLogin.this, "Enter correct Password", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }catch (Exception ex){
                    Toast.makeText(PoliceLogin.this,"User doesn't exist",Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }
        });

    }
}
