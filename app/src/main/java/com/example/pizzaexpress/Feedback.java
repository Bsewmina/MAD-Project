package com.example.pizzaexpress;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzaexpress.model.FeedbackDB;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Feedback extends AppCompatActivity {

    Spinner spinner,spinner2;
    FeedbackDB data;
    EditText txtInquiry, txtTitle, txtFname, txtLname, txtEmail, txtCountry, txtPno, txtMsg;
    Button BtnSave;
    DatabaseReference dbRef;
    FeedbackDB feedback;

    int maxid=0;

    //main method
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        spinner = findViewById(R.id.spinner1);
       //
        spinner2 = findViewById(R.id.spinner2);
        txtFname = findViewById(R.id.inputFirstname);
        txtLname = findViewById(R.id.inputLastname);
        txtEmail = findViewById(R.id.inputEmail);
        txtCountry = findViewById(R.id.inputCountry);
        txtPno = findViewById(R.id.inputPno);
        txtMsg = findViewById(R.id.inputMsg);

        BtnSave = findViewById(R.id.buttonSave);

        feedback = new FeedbackDB();

        dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback");
        List<String> categories = new ArrayList<>();
        categories.add(0, "Inquiry Type*");
        categories.add("Contact");
        categories.add("Oder Inquiry");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("choose event")) {

                } else {
                    String item = adapterView.getItemAtPosition(i).toString();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        List<String> categorie2 = new ArrayList<>();
        categorie2.add(0, "Title*");
        categorie2.add("MR");
        categorie2.add("MRS");
        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,categorie2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2.setAdapter(dataAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("choose event")) {

                } else {
                    String item = adapterView.getItemAtPosition(i).toString();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        BtnSave.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                String fName = (txtFname.getText().toString().trim());
                String lName = (txtLname.getText().toString().trim());
                String email = (txtEmail.getText().toString().trim());
                String country = (txtCountry.getText().toString().trim());
                Integer pNo = (Integer.parseInt(txtPno.getText().toString().trim()));
                String msg = (txtMsg.getText().toString().trim());

                feedback.setfName(txtFname.getText().toString().trim());
                feedback.setlName(txtLname.getText().toString().trim());
                feedback.setEmail(txtEmail.getText().toString().trim());
                feedback.setCountry(txtCountry.getText().toString().trim());
                feedback.setpNo(Integer.parseInt(txtPno.getText().toString().trim()));
                feedback.setMsg(txtMsg.getText().toString().trim());

                String spin = spinner.getSelectedItem().toString();

                if (spinner != null) {

                    feedback.setInquiry(spin);
                }

                String spin2 = spinner2.getSelectedItem().toString();
                if (spinner2 != null) {

                    feedback.setTitle(spin2);
                }

                dbRef.child(String.valueOf(maxid+1)).setValue(feedback);

                Toast.makeText(Feedback.this, "Registration Successfull", Toast.LENGTH_LONG).show();
                    //toast.show();



                }

        });

//        BtnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String title = (txtTitle.getText().toString().trim());
//                String fName = (txtFname.getText().toString().trim());
//                String lName = (txtLname.getText().toString().trim());
//                String email = (txtEmail.getText().toString().trim());
//                String country = (txtCountry.getText().toString().trim());
//                Integer pNo = (Integer.parseInt(txtPno.getText().toString().trim()));
//                String msg = (txtMsg.getText().toString().trim());
//
//                feedback.setTitle(txtTitle.getText().toString().trim());
//                feedback.setfName(txtFname.getText().toString().trim());
//                feedback.setlName(txtLname.getText().toString().trim());
//                feedback.setEmail(txtEmail.getText().toString().trim());
//                feedback.setCountry(txtCountry.getText().toString().trim());
//                feedback.setpNo(Integer.parseInt(txtPno.getText().toString().trim()));
//                feedback.setMsg(txtMsg.getText().toString().trim());
//
//                dbRef.child(String.valueOf(maxid + 1)).setValue(feedback);
//
//                Toast.makeText(Feedback.this, "Data Inserted Successfully!", Toast.LENGTH_LONG).show();
//            }
//        });

        //back button
        final ImageView backImgBtn = findViewById(R.id.Drink5_BackButton);
        backImgBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v1) {
                Intent launchActivity1 = new Intent(getApplicationContext(), Home.class);
                startActivity(launchActivity1);

            }
        });

        //Bottom navigation bar

        BottomNavigationView bottomNavigationView = findViewById(R.id.FeedbackbtmNavBar);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
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
    }
}