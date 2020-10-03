package com.example.pizzaexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Sides1_chickenWingsBbq extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides1_chicken_wings_bbq);

        //back button redirect to the home page
        final ImageView backImgBtn = findViewById(R.id.backBtn_cat);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),CategorySides.class);
                startActivity(launchActivity1);

            }
        });



    }
}
