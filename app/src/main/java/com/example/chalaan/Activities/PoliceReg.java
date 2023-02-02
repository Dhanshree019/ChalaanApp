package com.example.chalaan.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.chalaan.CardView1;
import com.example.chalaan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PoliceReg extends AppCompatActivity {

    private EditText userEmail,userPassword,userPAssword,userName;
    private ProgressBar loadigProgress;
    private Button regbtn;
    private Police police;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_reg);
        userEmail =findViewById(R.id.regMail);
        userPassword =findViewById(R.id.regPassword);
        userPAssword =findViewById(R.id.regPassword2);
        userName =findViewById(R.id.regName);
        loadigProgress =findViewById(R.id.regProgressBar);
        regbtn=findViewById(R.id.regBtn);
        police=new Police();
        database=FirebaseDatabase.getInstance();
        ref=database.getReference().child("Police");
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                police.setName(userName.getText().toString());
                police.setEmail(userEmail.getText().toString());
                police.setPassword(userPassword.getText().toString());

                ref.child(police.getEmail()).setValue(police).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(PoliceReg.this,"Police created  successful ",Toast.LENGTH_SHORT).show();
                            Intent start = new Intent(PoliceReg.this, PoliceLogin.class);
                            startActivity(start);
                        }else {
                            Toast.makeText(PoliceReg.this,"Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
