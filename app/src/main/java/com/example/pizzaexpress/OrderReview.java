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

import com.example.pizzaexpress.model.OderInfo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderReview extends AppCompatActivity {

    EditText txtFname, txtLname, txtEmail, txtPno;
    Button btnSave;

    DatabaseReference dbRef;

    OderInfo oderInfo;

    long maxid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);

       txtFname = (EditText)findViewById(R.id.Fname);
       txtLname = (EditText)findViewById(R.id.Lname);
       txtEmail = (EditText)findViewById(R.id.email);
       txtPno = (EditText)findViewById(R.id.phoneNumber);
       btnSave = (Button)findViewById(R.id.buttonSave);

       oderInfo = new OderInfo();

       dbRef = FirebaseDatabase.getInstance().getReference().child("OderInfo");
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
               String fname = (txtFname.getText().toString().trim());
               String lname = (txtLname.getText().toString().trim());
               String email = (txtEmail.getText().toString().trim());
               int pNo = Integer.parseInt(txtPno.getText().toString().trim());

               oderInfo.setFname(txtFname.getText().toString().trim());
               oderInfo.setLname(txtLname.getText().toString().trim());
               oderInfo.setEmail(txtEmail.getText().toString().trim());
               oderInfo.setpNo(pNo);

               dbRef.child(String.valueOf(maxid+1)).setValue(oderInfo);

               Toast.makeText(OrderReview.this,"Data Inserted Successfully!",Toast.LENGTH_LONG).show();

           }
       });
    }


    public void openNextActivity(){
        Intent intent = new Intent(this, OrderDelivery.class);
        startActivity(intent);

        //////////////////////////////////////
        //Bottom navigation bar

        BottomNavigationView bottomNavigationView = findViewById(R.id.OderReviewbotmNavBar);

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
        final ImageView backImgBtn = findViewById(R.id.OrderReviewBackButton);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1= new Intent(getApplicationContext(),MyCart.class);
                startActivity(launchActivity1);

            }
        });


    }
}
