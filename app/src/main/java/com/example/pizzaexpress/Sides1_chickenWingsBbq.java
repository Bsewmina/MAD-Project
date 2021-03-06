package com.example.pizzaexpress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sides1_chickenWingsBbq extends AppCompatActivity {

    //variable declaration
    TextView qty, vName, vPrice;
    RadioButton bSize;
    Button addToCart;
    DatabaseReference dbRef;
    CartAdd crt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides1_chicken_wings_bbq);

        //assign IDs to variables
        vName = findViewById(R.id.itemName);
        vPrice = findViewById(R.id.price);
        qty = findViewById(R.id.itemQty);

        addToCart = findViewById(R.id.itemBtt_AddToCart);

        //create java object
        crt = new CartAdd();


        //back button redirect to the home page
        final ImageView backImgBtn = findViewById(R.id.backBtn_cat);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),CategorySides.class);
                startActivity(launchActivity1);

            }
        });


        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Cart");
                try {

                    crt.setItmName(vName.getText().toString().trim());
                    crt.setPrice(vPrice.getText().toString().trim());
                    crt.setSize(bSize.getText().toString().trim());
                    crt.setQty(Integer.parseInt(qty.getText().toString().trim()));
                    dbRef.child("item1").setValue(crt);
                    Toast.makeText(getApplicationContext(), "Added to Cart", Toast.LENGTH_SHORT).show();


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
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
                price.setText("Rs. 450");
                bSize = findViewById(R.id.size_small);
                break;
            case R.id.size_medium:
                price.setText("Rs. 800");
                bSize = findViewById(R.id.size_medium);
                break;
            case R.id.size_large:
                price.setText("Rs. 1500");
                bSize = findViewById(R.id.size_large);
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
