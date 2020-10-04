package com.example.pizzaexpress;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Dessert4_mooncake extends AppCompatActivity {

    TextView qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert4_mooncake);

        qty = findViewById(R.id.Qty);


    }
    //increase quantity
    public void increaseItemQty(View view){

        int temp;String text;
        temp = Integer.parseInt(qty.getText().toString());
        temp ++;
        text = String.valueOf(temp);
        qty.setText(text);
    }

    //decrease quantity
    public void decreaseItemQty(View view){

        int temp;String text;

        temp = Integer.parseInt(qty.getText().toString());
        if (temp == 1){
            Toast.makeText(this, "Qty should be at least 01", Toast.LENGTH_SHORT).show();
        }
        else{
            temp--;
            text = String.valueOf(temp);
            qty.setText(text);
        }
    }
}