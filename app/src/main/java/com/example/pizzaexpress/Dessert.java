package com.example.pizzaexpress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dessert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

        //back button redirect to the home page
        final ImageView backImgBtn = findViewById(R.id.floatingActionButton3);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1 = new Intent(getApplicationContext(), Home.class);
                startActivity(launchActivity1);

            }

        });


        //Navigate inside the Item
        CardView cardObj = findViewById(R.id.item_dessert1);
        cardObj.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intObj = new Intent(getApplicationContext(), Dessert1_lava.class);
                startActivity(intObj);
            }


        });

        //Navigate inside the Item
        CardView cardObj2 = findViewById(R.id.item_dessert2);
        cardObj2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intObj2 = new Intent(getApplicationContext(), Dessert2_macaroon.class);
                startActivity(intObj2);
            }


        });

        //Navigate inside the Item
        CardView cardObj3 = findViewById(R.id.item_dessert3);
        cardObj3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intObj3 = new Intent(getApplicationContext(), Dessert3_banoffee.class);
                startActivity(intObj3);
            }


        });

        //Navigate inside the Item
        CardView cardObj4 = findViewById(R.id.item_dessert4);
        cardObj4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intObj4 = new Intent(getApplicationContext(), Dessert4_mooncake.class);
                startActivity(intObj4);
            }


        });

        //Navigate inside the Item
        CardView cardObj5 = findViewById(R.id.item_dessert5);
        cardObj5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intObj5 = new Intent(getApplicationContext(), Dessert5_stick.class);
                startActivity(intObj5);
            }


        });

        //Navigate inside the Item
        CardView cardObj6 = findViewById(R.id.item_dessert6);
        cardObj6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intObj6 = new Intent(getApplicationContext(), Dessert6_whoopie.class);
                startActivity(intObj6);
            }


        });

    }
}