package com.example.pizzaexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Beverages_pg1 extends AppCompatActivity {

    TextView qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages_pg1);

        qty = findViewById(R.id.itemQty);

        //back button
        final ImageView backImgBtn = findViewById(R.id.Drink1_BackButton);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                    Intent launchActivity1= new Intent(getApplicationContext(),CategoryBeverages.class);
                    startActivity(launchActivity1);


                    }
                });

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

