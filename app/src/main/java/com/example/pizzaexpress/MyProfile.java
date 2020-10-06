package com.example.pizzaexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MyProfile extends AppCompatActivity {
    //>>>>>> temp global val
    final String temp = "0112";

    EditText userName,userMobile,userEmail,userAddress,userPassword;
    Button submitBtn;
    UserProfile userObj;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        userName = findViewById(R.id.profileUsername);
        userEmail = findViewById(R.id.profileTextEmail);
        userMobile = findViewById(R.id.profileTextMobile);
        userAddress = findViewById(R.id.profileTextAddress);
        userPassword = findViewById(R.id.profileTextPass);
        submitBtn = findViewById(R.id.profileSubmit);

        userObj = new UserProfile();


        //add data to DB
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbRef = FirebaseDatabase.getInstance().getReference();

                if (TextUtils.isEmpty(userName.getText().toString().trim())) {

                    userName.setError("Enter User Name");
                    userName.requestFocus();
                }
                if (TextUtils.isEmpty(userMobile.getText().toString())) {
                    userMobile.setError("Enter Mobile Number");
                    userMobile.requestFocus();
                }
                if (TextUtils.isEmpty(userEmail.getText().toString().trim())) {
                    userEmail.setError("Enter Email");
                    userEmail.requestFocus();
                }
                if (TextUtils.isEmpty(userAddress.getText().toString().trim())) {
                    userAddress.setError("Enter address");
                    userAddress.requestFocus();
                }
                if (TextUtils.isEmpty(userPassword.getText().toString().trim())) {
                    userPassword.setError("Enter password");
                    userPassword.requestFocus();

                } else {

                    dbRef.child("Users").child(temp).child("userName").setValue(userName.getText().toString().trim());
                    dbRef.child("Users").child(temp).child("phoneNumber").setValue(Integer.parseInt(userMobile.getText().toString()));
                    dbRef.child("Users").child(temp).child("email").setValue(userEmail.getText().toString());
                    dbRef.child("Users").child(temp).child("address").setValue(userAddress.getText().toString());
                    dbRef.child("Users").child(temp).child("password").setValue(userPassword.getText().toString());

                    //clear input fields
                    ClearData();

                }
            }

        });



        }


    public void ClearData(){
        userName.setText("");
        userMobile.setText("");
        userEmail.setText("");
        userAddress.setText("");
        userPassword.setText("");
        Toast.makeText(this,"Successfully updated",Toast.LENGTH_SHORT).show();

    }

}