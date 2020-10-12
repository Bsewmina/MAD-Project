package com.example.pizzaexpress;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Feedback extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    //main method
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);



    //back button
    final ImageView backImgBtn = findViewById(R.id.Drink5_BackButton);
        backImgBtn.setOnClickListener(new View.OnClickListener()

    {

        @Override
        public void onClick (View v1){
        Intent launchActivity1 = new Intent(getApplicationContext(), Home.class);
        startActivity(launchActivity1);

    }
    });

    //Bottom navigation bar

    BottomNavigationView bottomNavigationView = findViewById(R.id.FeedbackbtmNavBar);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener()

    {
        @Override
        public void onNavigationItemReselected (@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.Home:
                break;

            case R.id.cart:
                startActivity(new Intent(getApplicationContext(), MyCart.class));
                break;

            case R.id.favourite:
                startActivity(new Intent(getApplicationContext(), Favourites.class));
                break;

            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), Account.class));
                break;
        }

    }
    });
    //spinner1
    Spinner spinner = findViewById(R.id.spinner1);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.inquiry, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);

    //spinner2
    Spinner spinner1 = findViewById(R.id.spinner2);
    ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.title, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinner1.setAdapter(adapter1);
            spinner1.setOnItemSelectedListener(this);

    }

        @Override
        public void onItemSelected (AdapterView < ? > adapterView, View view,int i, long l){
            String text = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }


}