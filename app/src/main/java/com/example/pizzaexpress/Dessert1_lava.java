package com.example.pizzaexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dessert1_lava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert1_lava);

        final ImageView backImgBtn = findViewById(R.id.back_cat);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),Home.class);
                startActivity(launchActivity1);

            }
        });
    }
}