package com.example.pizzaexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DialogQuantityActivity extends AppCompatActivity {


    TextView  quantityTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_quantity);
        //init layout views



        ImageButton decrementBtn = findViewById(R.id.decrementBtn);
        quantityTv = findViewById(R.id.quantityTv);
        ImageButton incrementBtn = findViewById(R.id.incrementBtn);
        Button continueBtn = findViewById(R.id.continueBtn);
        TextView originalPriceTv = findViewById(R.id.originalPriceTV);


        //back button redirect to the valueOffer page
        final ImageView backImgBtn = findViewById(R.id.floatingActionButton14);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),Displayed_Option_list.class);
                startActivity(launchActivity1);

            }
        });



    }

        //increase quantity
        public void increaseItemQty(View view){

            int temp;String text;
            temp = Integer.parseInt(quantityTv .getText().toString());
            temp ++;
            text = String.valueOf(temp);
            quantityTv .setText(text);
        }

        //decrease quantity
        public void decreaseItemQty(View view){

            int temp;String text;

            temp = Integer.parseInt( quantityTv.getText().toString());
            if (temp == 1){
                Toast.makeText(this, "Qty should be at least 01", Toast.LENGTH_SHORT).show();
            }
            else{
                temp--;
                text = String.valueOf(temp);
                quantityTv.setText(text);
            }
        }



}