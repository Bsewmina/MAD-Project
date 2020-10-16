package com.example.pizzaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Displayed_Option_list extends AppCompatActivity {


    Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayed__option_list);


        continueBtn = findViewById(R.id.Add_to_cart_1);


        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DialogQuantityActivity.class));
            }
        });



        //back button redirect to the valueOffer page
        final ImageView backImgBtn = findViewById(R.id.floatingActionButton6);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),Offer1Options.class);
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