package com.example.pizzaexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sides1_chickenWingsBbq extends AppCompatActivity {

    TextView qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides1_chicken_wings_bbq);

        qty = findViewById(R.id.itemQty);

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

    //Size selection method
    public void onAlignmentSelected(View view) {
        TextView price = findViewById(R.id.price);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.size_small:
                price.setText("Rs. 450");
                break;
            case R.id.size_medium:
                price.setText("Rs. 800");
                break;
            case R.id.size_large:
                price.setText("Rs. 1500");
                break;

        }
    }

    //increase quantity
    public void increaseItemQty1(View view){
        int temp;
        String text;
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
