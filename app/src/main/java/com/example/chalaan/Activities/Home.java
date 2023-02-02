package com.example.chalaan.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.chalaan.Activities.ui.gallery.GalleryFragment;
import com.example.chalaan.Activities.ui.gallery.GalleryViewModel;
import com.example.chalaan.Activities.ui.home.HomeFragment;
import com.example.chalaan.Activities.ui.slideshow.SlideshowFragment;
import com.example.chalaan.Activities.ui.tools.ToolsFragment;
import com.example.chalaan.Arrow;
import com.example.chalaan.Fragments.ShareFragment;
import com.example.chalaan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    FirebaseUser currentUser;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

//        ImageView icon=new ImageView(this);
//        icon.setImageResource(R.drawable.ic_arrow);
//        final FloatingActionButton fab=new FloatingActionButton.Builder(this).setConte


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home.this, Arrow.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });




        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        if (savedInstanceState== null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }




        updateNavHeader();


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.container);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.container);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void updateNavHeader() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.nav_username);
        TextView navUsermail = headerView.findViewById(R.id.nav_user_mail);
        ImageView navUserPhoto = headerView.findViewById(R.id.nav_user_photo);

        navUsermail.setText(currentUser.getEmail());
        navUsername.setText(currentUser.getDisplayName());

        Glide.with(this).load(currentUser.getPhotoUrl()).into(navUserPhoto);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_home) {

            Toast.makeText(this, "This is home fragment", Toast.LENGTH_SHORT).show();

//            getActionBar().setTitle("Home");
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

        } else if (id == R.id.nav_profile) {

            Toast.makeText(this, "This is profile fragment", Toast.LENGTH_SHORT).show();


//            getActionBar().setTitle("Profile");
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.container,new GalleryFragment()).commit();

        } else if (id == R.id.nav_documents) {

            Toast.makeText(this, "This is document fragment", Toast.LENGTH_SHORT).show();


//            getActionBar().setTitle("Documents");
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.container,new SlideshowFragment()).commit();

        }  else if (id == R.id.nav_share) {
            Toast.makeText(this, "This is share fragment", Toast.LENGTH_SHORT).show();


//            getActionBar().setTitle("Share");
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ShareFragment()).commit();

        }

        else if (id == R.id.nav_signout) {
//
            FirebaseAuth.getInstance().signOut();
            Intent loginActivity=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(loginActivity);
            finish();

        }

        return false;
//        DrawerLayout drawer =(DrawerLayout)findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
    }

}
//
//            getSupportActionBar().setTitle("Home");

//            getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

//
//        } else if (id == R.id.nav_profile) {
//
//            getSupportActionBar().setTitle("Profile");
//            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();
//
//        } else if (id == R.id.nav_settings) {
//
//            getSupportActionBar().setTitle("Settings");
//            getSupportFragmentManager().beginTransaction().replace(R.id.container,new SettingsFragment()).commit();
//
//
//        }
//        else if (id == R.id.nav_signout) {
//
//
//
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//
//    }


