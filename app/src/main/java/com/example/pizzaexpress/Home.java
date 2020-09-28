package com.example.pizzaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //redirect to the pizza page
        final ImageView pizzaImgBtn = findViewById(R.id.category1_pizza_imgBtn);
        pizzaImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),CategoryPizza.class);
                startActivity(launchActivity1);

            }
        });

        //redirect to the sides and other page
        final ImageView sidesImgBtn = findViewById(R.id.category2_sides_imgBtn);
        sidesImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),CategoryPizza.class);
                startActivity(launchActivity1);

            }
        });

        //redirect to the beverages page
        final ImageView bevImgBtn = findViewById(R.id.category3_beverages_imgBtn);
        bevImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),CategoryPizza.class);
                startActivity(launchActivity1);

            }
        });

        //redirect to the desserts page
        final ImageView dessertImgBtn = findViewById(R.id.category4_desserts_imgBtn);
        dessertImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),CategoryPizza.class);
                startActivity(launchActivity1);

            }
        });



        // View Navigation Drawer
        ImageView backImgBtn = findViewById(R.id.navBackBtn);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                DrawerLayout drawer = findViewById(R.id.drawerLay);
                drawer.openDrawer(GravityCompat.START);

            }
        });



        //////////////////////////////////////
        //Bottom navigation bar

        BottomNavigationView bottomNavigationView = findViewById(R.id.botmNavBar);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home:

                        break;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(),CategoryPizza.class));
                        break;

                    case R.id.favourite:
                        startActivity(new Intent(getApplicationContext(),Favourites.class));
                        break;

                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(),Account.class));
                        break;
                }

            }
        });

        /////////////////////////////////
        //Side Navigation Bar
        NavigationView navigationView = findViewById(R.id.sideNavBar);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navOffers:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        return true;
                    case R.id.navOrderhis:
                        startActivity(new Intent(getApplicationContext(), OrderHistory.class));
                        return true;
                    case R.id.navFav:
                        startActivity(new Intent(getApplicationContext(), Favourites.class));
                        return true;

                }
                return false;
            }
        });



    }
}