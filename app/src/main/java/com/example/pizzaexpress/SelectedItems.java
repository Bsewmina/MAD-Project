package com.example.pizzaexpress;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SelectedItems extends AppCompatActivity {

    TextView item,price,qty;
    Button btn;
    DatabaseReference dbref;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item);


        item = (TextView)findViewById(R.id.textView8);
        price = (TextView)findViewById(R.id.itemPrice);
        qty = (TextView)findViewById(R.id.textView6);
        btn = (Button)findViewById(R.id.deliverybuttonSave);

                dbref= FirebaseDatabase.getInstance().getReference().child("Cart").child("0712345674").child("item1");
                dbref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String i=snapshot.child("itmName").getValue().toString();
                        String p=snapshot.child("price").getValue().toString();
                        String q=snapshot.child("qty").getValue().toString();
                        item.setText(i);
                        price.setText(p);
                        qty.setText(q);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }


        });


















        //back button
        final ImageView backImgBtn = findViewById(R.id.SelectedItemBackButton);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),OrderDelivery.class);
                startActivity(launchActivity1);

            }
        });

        //Bottom navigation bar

        BottomNavigationView bottomNavigationView = findViewById(R.id.selectedBackNavBar);

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

    }
}
