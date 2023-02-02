package com.example.chalaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.chalaan.Activities.LoginActivity;
import com.example.chalaan.Activities.SignUp;

public class CardView1 extends AppCompatActivity {
    CardView cv1,cv2,cv3,cv4,cv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view1);

        cv1=(CardView)findViewById(R.id.cv1);
        cv2=(CardView)findViewById(R.id.cv2);
        cv3=(CardView)findViewById(R.id.cv3);
        cv4=(CardView)findViewById(R.id.cv4);
        cv5=(CardView)findViewById(R.id.cv5);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CardView1.this, Pincode.class);
                startActivity(intent);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CardView1.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CardView1.this,About.class);
                startActivity(intent);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CardView1.this,Intro2.class);
                startActivity(intent);
            }
        });

        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CardView1.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
