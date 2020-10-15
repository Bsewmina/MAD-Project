package com.example.pizzaexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzaexpress.model.Transaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderDelivery extends AppCompatActivity {

    EditText txtHno, txtstreet, txtcity;
    Button btnSave;

    DatabaseReference dbRef;

    Transaction transaction;

    long maxid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_delivery);

        txtHno = (EditText)findViewById(R.id.addNo);
        txtstreet = (EditText)findViewById(R.id.streetName);
        txtcity = (EditText)findViewById(R.id.cityName);
        btnSave = (Button)findViewById(R.id.deliverybuttonSave);

        transaction = new Transaction();

        dbRef = FirebaseDatabase.getInstance().getReference().child("Transaction");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxid=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hno = (txtHno.getText().toString().trim());
                String street = (txtstreet.getText().toString().trim());
                String city = (txtcity.getText().toString().trim());

                transaction.setHno(txtHno.getText().toString().trim());
                transaction.setStreet(txtstreet.getText().toString().trim());
                transaction.setCity(txtcity.getText().toString().trim());


                dbRef.child(String.valueOf(maxid+1)).setValue(transaction);


                Toast.makeText(OrderDelivery.this,"Data Inserted Successfully!",Toast.LENGTH_LONG).show();
                openNextActivity();

            }
        });


        //Bottom navigation bar

        BottomNavigationView bottomNavigationView = findViewById(R.id.OderDeliverybotmNavBar);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home:
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
        //back button
        final ImageView backImgBtn = findViewById(R.id.OrderDeliveryBackButton);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),OrderReview.class);
                startActivity(launchActivity1);

            }
        });

    }
    public void openNextActivity() {
        Intent intent = new Intent(getApplicationContext(), SelectedItems.class);
        startActivity(intent);
    }
}

