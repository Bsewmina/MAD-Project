package com.example.pizzaexpress;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //attributes
    private String inquiry;
    private String Title;
    private String fName;
    private String lName;
    private String email;
    private String country;
    private Integer pNo;
    private String msg;

    //constructor
    public Feedback() {
    }

    //getters and setters
    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public String getSTitle() {
        return Title;
    }

    public void setSTitle(String Title) {
        this.Title = Title;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public Integer getpNo() {
        return pNo;
    }

    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    EditText txtInquiry, txtTitle, txtFname, txtLname, txtEmail, txtCountry, txtPno, txtMsg;
    Button BtnSave;
    DatabaseReference dbRef;
    Feedback feedback;

    //main method
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        txtInquiry = findViewById(R.id.spinner1);
        txtTitle = findViewById(R.id.spinner2);
        txtFname = findViewById(R.id.inputFirstname);
        txtLname = findViewById(R.id.inputLastname);
        txtEmail = findViewById(R.id.inputEmail);
        txtCountry = findViewById(R.id.inputCountry);
        txtPno = findViewById(R.id.inputPno);
        txtMsg = findViewById(R.id.inputMsg);

        BtnSave = findViewById(R.id.buttonSave);

        feedback = new Feedback();

        //button save
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback");
                try {
                    if (TextUtils.isEmpty(txtInquiry.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Empty Inquiry", Toast.LENGTH_SHORT).show();
                    if (TextUtils.isEmpty(txtTitle.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Empty Title", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtFname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty First Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtLname.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Last Name", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtEmail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtCountry.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Country", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtPno.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Phone Number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtMsg.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Message", Toast.LENGTH_SHORT).show();
                    else {
                        feedback.setInquiry(txtInquiry.getText().toString().trim());
                        feedback.setSTitle(txtTitle.getText().toString().trim());
                        feedback.setfName(txtFname.getText().toString().trim());
                        feedback.setlName(txtLname.getText().toString().trim());
                        feedback.setEmail(txtEmail.getText().toString().trim());
                        feedback.setCountry(txtCountry.getText().toString().trim());
                        feedback.setpNo(Integer.parseInt(txtPno.getText().toString().trim()));
                        feedback.setMsg(txtMsg.getText().toString().trim());
                        dbRef.child("feedback1").setValue(feedback);

                        Toast.makeText(getApplicationContext(), "Successfully inserted ", Toast.LENGTH_SHORT).show();
                        clearConsole();
                    }
                } catch (NumberFormatException nfe) {
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number ", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
        private void clearConsole(){

            txtInquiry.setText("");
            txtTitle.setText("");
            txtFname.setText("");
            txtLname.setText("");
            txtEmail.setText("");
            txtCountry.setText("");
            txtPno.setText("");
            txtMsg.setText("");

    }

}