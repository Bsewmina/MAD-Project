package com.example.pizzaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Pizza2_MeatLoversChicken extends AppCompatActivity {

    private TextView qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza2__meat_lovers_chicken);

        qty = findViewById(R.id.itemQty);

        //back button redirect to the home page
        final ImageView backImgBtn = findViewById(R.id.backBtn_cat);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),CategoryPizza.class);
                startActivity(launchActivity1);

            }
        });


        //Bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.botmNavBar);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        break;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(),MyCart.class));
                        break;

                    case R.id.favourite:
                        startActivity(new Intent(getApplicationContext(),Favourites.class));
                        break;

                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(),Account.class));
                        break;
                }

            }
        });

    }





    //Size selection method
    public void onAlignmentSelected(View view) {
        TextView price = findViewById(R.id.price);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.size_small:
                price.setText("Rs. 900");
                break;
            case R.id.size_medium:
                price.setText("Rs. 1200");
                break;
            case R.id.size_large:
                price.setText("Rs. 2500");
                break;

        }
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