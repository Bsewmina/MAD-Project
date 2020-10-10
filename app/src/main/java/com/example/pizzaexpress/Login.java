package com.example.pizzaexpress;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    EditText mPhone,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    DatabaseReference dbref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mPhone = findViewById(R.id.phone);
        mPassword = findViewById(R.id.password);
        mLoginBtn = findViewById(R.id.loginBtn);
        mCreateBtn = findViewById(R.id.createText);


        User user=new User();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dbref = FirebaseDatabase.getInstance().getReference().child("Customer");
                dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            User details1 = dataSnapshot1.getValue(User.class);

                            if (mPhone.getText().toString().equalsIgnoreCase(details1.getPhoneNo().toString()) &&
                                    mPassword.getText().toString().equalsIgnoreCase(details1.getPassword().toString())) {

                                String data = mPhone.getText().toString().trim();

                                Intent intent = new Intent(Login.this, Home.class);

                                intent.putExtra("pno",data);

                                startActivity(intent);
                                break;

                            }
                            if (!mPhone.getText().toString().equalsIgnoreCase(details1.getPhoneNo().toString()) &&
                                    !mPassword.getText().toString().equalsIgnoreCase(details1.getPassword().toString()))
                            {
                                //Longin failed feedback
                                Toast.makeText(Login.this, "password and email mismatch", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }


        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }
}
