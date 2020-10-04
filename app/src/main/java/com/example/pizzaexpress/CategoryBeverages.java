package com.example.pizzaexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CategoryBeverages extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_beverages);

       //back button
        final ImageView backImgBtn = findViewById(R.id.Drink5_BackButton);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),Home.class);
                startActivity(launchActivity1);

            }
        });



        //Bottom navigation bar

        BottomNavigationView bottomNavigationView = findViewById(R.id.FeedbackbtmNavBar);

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

        //Navigate inside the Item1
        CardView cardObj1 = findViewById(R.id.backBtn_cat_drink1);
        cardObj1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(), Beverages_pg1.class);
                startActivity(intObj);
            }


        });

        //Navigate inside the Item2
        CardView cardObj2 = findViewById(R.id.backBtn_cat_drink2);
        cardObj2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),beverages_pg2.class);
                startActivity(intObj);
            }


        });

        //Navigate inside the Item3
        CardView cardObj3 = findViewById(R.id.backBtn_cat_drink3);
        cardObj3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),beverages_pg3.class);
                startActivity(intObj);
            }


        });

        //Navigate inside the Item4
        CardView cardObj4 = findViewById(R.id.backBtn_cat_drink4);
        cardObj4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),beverages_pg4.class);
                startActivity(intObj);
            }


        });

        //Navigate inside the Item5
        CardView cardObj5 = findViewById(R.id.backBtn_cat_drink5);
        cardObj5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),beverages_pg5.class);
                startActivity(intObj);
            }


        });

        //Navigate inside the Item6
        CardView cardObj6 = findViewById(R.id.backBtn_cat_drink6);
        cardObj6.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),beverages_pg6.class);
                startActivity(intObj);
            }


        });

    }


}
