package com.example.pizzaexpress;


import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;


        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.pizzaexpress.database.DBReference;
        import com.example.pizzaexpress.model.User;
        import com.example.pizzaexpress.sessions.SessionManagement;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    TextView createAc;
    Button login;
    ProgressDialog loadingBar ;

    private EditText phone;
    private EditText password;
    private String parentDBName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);


        createAc = findViewById(R.id.createText);
        login = findViewById(R.id.loginBtn);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        loadingBar = new ProgressDialog(this);

        createAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SessionManagement sm = new SessionManagement(Login.this);
        String phone = sm.getSession();

        if(!phone.equals("empty")){
            if(!phone.equals("admin")) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
            }
        }

    }

    private void LoginUser() {

        User ui = new User();

        ui.setPhone((phone.getText().toString()));
        ui.setPassword(password.getText().toString());


        if(TextUtils.isEmpty(ui.getPassword())){
            Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(ui.getPhone().toString())){
            Toast.makeText(this, "Please Enter Your Mobile Number", Toast.LENGTH_SHORT).show();
        }

        else{
            loadingBar.setTitle("Login Account");
            loadingBar.setMessage("Please Wait, We Are Checking The Credentials");

            loadingBar.setCanceledOnTouchOutside(false);

            loadingBar.show();

            AllowAccessToAccount(ui.getPhone().toString(),ui.getPassword());
        }
    }

    private void AllowAccessToAccount(final String  phone, final String password) {

        DBReference dbref = new DBReference();

        dbref.getRootRef().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.child(parentDBName).child(phone).exists()) {

                    if (dataSnapshot.child(parentDBName).child(phone).child("type").exists()) {

                        SessionManagement sm = new SessionManagement(Login.this);
                        sm.saveSession("admin");

                        Toast.makeText(Login.this, "Logged In Successfully..", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                        Intent intent = new Intent(Login.this, Home.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }else {

                        User u = dataSnapshot.child(parentDBName).child(phone).getValue(User.class);
                        if (u.getStatus() == true) {

                            if (u.getPassword().equals(password)) {
                                SessionManagement sm = new SessionManagement(Login.this);
                                sm.saveSession(phone);

                                Toast.makeText(Login.this, "Logged In Successfully..", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);
                            } else {
                                Toast.makeText(Login.this, "Your Password Is Incorrect ", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        } else {
                            Toast.makeText(Login.this, "This " + phone + " Does Not Exist", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }

                    }

                }
                else{
                    Toast.makeText(Login.this, "This " + phone +" Does Not Exist", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}