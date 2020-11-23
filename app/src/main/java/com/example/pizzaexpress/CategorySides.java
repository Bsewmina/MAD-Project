package com.example.pizzaexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CategorySides extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_sides);


        //back button redirect to the home page
        final ImageView backImgBtn = findViewById(R.id.imageButton);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),Home.class);
                startActivity(launchActivity1);

            }
        });

        //Navigate inside the Sides1
        CardView cardObj = findViewById(R.id.sideCard1);
        cardObj.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),Sides1_chickenWingsBbq.class);
                startActivity(intObj);
            }


        });

        //Navigate inside the Sides2
        CardView cardObj2 = findViewById(R.id.sideCard2);
        cardObj2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intObj= new Intent(getApplicationContext(),Sides2_chickenWingsGarlic.class);
                startActivity(intObj);
            }


        });
    }
}
