package com.example.chalaan;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chalaan.Activities.Home;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class Arrow extends AppCompatActivity {

    CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrow);
        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.ic_menu_vector, R.drawable.close);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"), R.drawable.home_white)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.ic_alert)
                .addSubMenu(Color.parseColor("#FF4B32"), R.drawable.ic_favorite)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.rules)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.ic_edit);


        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {

                                                 @Override
                                                 public void onMenuSelected(int index) {
                                                     switch (index) {
                                                         case 0:
                                                             Toast.makeText(Arrow.this, "Home Button Clicked", Toast.LENGTH_SHORT).show();
                                                             startActivity(new Intent(Arrow.this, Home.class));
                                                             break;
                                                         case 1:
                                                             Toast.makeText(Arrow.this, "Search button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 2:
                                                             Toast.makeText(Arrow.this, "Notify button Clciked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                         case 3:
                                                             Toast.makeText(Arrow.this, "Rule button Clcked", Toast.LENGTH_SHORT).show();
                                                             startActivity(new Intent(Arrow.this,Rules.class));
                                                             break;
                                                         case 4:
                                                             Toast.makeText(Arrow.this, "GPS button Clicked", Toast.LENGTH_SHORT).show();
                                                             break;
                                                     }
                                                 }
                                             }

        );

        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

                                                     @Override
                                                     public void onMenuOpened() {

                                                     }

                                                     @Override
                                                     public void onMenuClosed() {

                                                     }
                                                 }
        );
    }

    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened())
            circleMenu.closeMenu();
        else
            finish();
    }

}
