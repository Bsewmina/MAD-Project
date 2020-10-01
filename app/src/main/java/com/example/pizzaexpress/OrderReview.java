package com.example.pizzaexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrderReview extends AppCompatActivity {

    private Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNextActivity();
            }
        });
    }

    public void openNextActivity(){
        Intent intent = new Intent(this, OrderDelivery.class);
        startActivity(intent);
    }
}
