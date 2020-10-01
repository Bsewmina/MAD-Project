package com.example.pizzaexpress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Pizza1_sausageDelight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza1_sausage_delight);

        //back button redirect to the home page
        final ImageView backImgBtn = findViewById(R.id.backBtn_cat);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),Home.class);
                startActivity(launchActivity1);

            }
        });



    }
}