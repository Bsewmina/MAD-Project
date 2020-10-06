package com.example.pizzaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CategoryPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_pizza);

    //back button redirect to the home page
    final ImageView backImgBtn = findViewById(R.id.backBtn);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v1) {
            Intent launchActivity1= new Intent(getApplicationContext(),Home.class);
            startActivity(launchActivity1);

        }
    });

        //Navigate inside the Item
        CardView cardObj = findViewById(R.id.catg_1);
        cardObj.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),Pizza1_sausageDelight.class);
                startActivity(intObj);
            }


        });

        CardView cardObj2 = findViewById(R.id.catg_2);
        cardObj2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),Pizza2_MeatLoversChicken.class);
                startActivity(intObj);
            }


        });

        CardView cardObj3 = findViewById(R.id.catg_3);
        cardObj3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),Pizza1_sausageDelight.class);
                startActivity(intObj);
            }


        });

        CardView cardObj4 = findViewById(R.id.catg_4);
        cardObj4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),Pizza1_sausageDelight.class);
                startActivity(intObj);
            }


        });

        //Bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.botmNavBar);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
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