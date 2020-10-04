package com.example.pizzaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ValueOffers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_offers);



        //back button redirect to the home page
        final ImageView backImgBtn = findViewById(R.id.floatingActionButton);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),Home.class);
                startActivity(launchActivity1);

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
                    startActivity(new Intent(getApplicationContext(),MyCart.class));
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

    }

}