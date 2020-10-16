package com.example.pizzaexpress;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

        public class Register extends AppCompatActivity {

            EditText mFullName, mEmail, mPassword, mPhone,mAddress;
            Button mRegisterBtn;
            TextView mLoginBtn;
            DatabaseReference ref;
            FirebaseDatabase rootNode;



            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_register);
                //init layout views
                mFullName = findViewById(R.id.fullName);
                mEmail = findViewById(R.id.Email);
                mPassword = findViewById(R.id.password);
                mPhone = findViewById(R.id.phone);
                mAddress = findViewById(R.id.address);
                mRegisterBtn = findViewById(R.id.registerBtn);
                mLoginBtn = findViewById(R.id.createText);


                mRegisterBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        rootNode= FirebaseDatabase.getInstance();
                        ref=  rootNode.getReference( "Customer");

                        if (mPassword.getText().length() < 7)
                            Toast.makeText(getApplicationContext(), "Password is not valid", Toast.LENGTH_SHORT).show();
                        else if (mEmail.getText().length() < 1)
                            Toast.makeText(getApplicationContext(), "Email is required", Toast.LENGTH_SHORT).show();
                        else if (mPhone.getText().length() < 10)
                            Toast.makeText(getApplicationContext(), "Phone number is not valid", Toast.LENGTH_SHORT).show();
                        else if (mFullName.getText().length() < 1)
                            Toast.makeText(getApplicationContext(), "Full Name is required", Toast.LENGTH_SHORT).show();
                        else {

                            //get data from User class
                            String name= mFullName.getText().toString().trim();
                            String email   =mEmail.getText().toString().trim();
                            String phoneNo  = mPhone.getText().toString().trim();
                            String password= mPassword.getText().toString().trim();
                            String address = mAddress.getText().toString().trim();
                            String points = "20.00";

                            User user= new User(email,password,name,phoneNo,address,points);


                            ref.child(phoneNo).setValue(user);

                            Toast.makeText(getApplicationContext(), "Account created successfully!", Toast.LENGTH_SHORT).show();
                            Intent newInt = new Intent(Register.this, Login.class);
                            newInt.putExtra("pno",phoneNo);
                            startActivity(newInt);
                        }

                    }

                });

                mLoginBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Login.class));
                    }
                });

            }




        }
