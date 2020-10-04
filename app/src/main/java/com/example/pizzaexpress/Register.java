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

        import com.example.pizzaexpress.model.User;
        import com.example.pizzaexpress.sessions.SessionManagement;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.HashMap;
public class Register extends AppCompatActivity {


    private Button createAcbtn;
    TextView mLoginBtn;
    private EditText Inputname , Inputpw , Inputconpw, Inputemail ,Inputphone;
    private ProgressDialog loadingBar;
    private String parentDBName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        createAcbtn=findViewById(R.id.registerBtn);
        mLoginBtn = findViewById(R.id.createText);
        Inputname =findViewById(R.id.fullName);
        Inputemail =findViewById(R.id.Email);
        Inputpw = findViewById(R.id.password);
        Inputphone= findViewById(R.id.phone);
        Inputconpw= findViewById(R.id.conpw);
        loadingBar = new ProgressDialog(this);


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
        createAcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateAccount();
            }
        });

    }

    private void CreateAccount() {

        String conpw = Inputconpw.getText().toString();

        User ui = new User();
        ui.setName(Inputname.getText().toString());
        ui.setPassword(Inputpw.getText().toString());
        ui.setPhone(Inputphone.getText().toString());
        ui.setEmail(Inputemail.getText().toString());
        ui.setAddress("");
        ui.setStatus(true);

        String name = ui.getName();
        String pw = ui.getPassword();
        String phone = ui.getPhone();
        String email = ui.getEmail();
        String addr = ui.getAddress();
        boolean status = ui.getStatus();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(pw)){
            Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(phone.toString())){
            Toast.makeText(this, "Please Enter Your Mobile Number", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(conpw)){
            Toast.makeText(this, "Please Enter Your Password Again", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
        }

        else{
            loadingBar.setTitle("Create Account");
            loadingBar.setMessage("Please Wait, We Are Checking The Credentials");

            loadingBar.setCanceledOnTouchOutside(false);

            loadingBar.show();

            Validatephone(name,phone,pw,conpw,email,addr,status);
        }

    }

    private void Validatephone(final String name, final String phone, final String pw, final String conpw,final String email,final String address,final boolean status) {

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User u = dataSnapshot.child(parentDBName).child(phone).getValue(User.class);
                if (u.getStatus() != true) {

                    if(pw.equals(conpw) ) {
                        HashMap<String, Object> userdataMap = new HashMap<>();
                        userdataMap.put("phone number", phone);
                        userdataMap.put("name", name);
                        userdataMap.put("password", pw);
                        userdataMap.put("email", email);
                        userdataMap.put("address",address);
                        userdataMap.put("status",status);

                        RootRef.child("Users").child(phone).updateChildren(userdataMap)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(Register.this, "Your Account Is Created Successfully..", Toast.LENGTH_SHORT).show();
                                            loadingBar.dismiss();

                                            User u = new User();

                                            u.setPhone(phone);
                                            u.setName(name);
                                            u.setPassword(pw);
                                            u.setEmail(email);

                                            SessionManagement sm = new SessionManagement(Register.this);
                                            sm.saveSession(phone);
                                            sm.save("switch_on");
                                            sm.orderPref("empty");

                                            Intent intent= new Intent(Register.this,MainActivity.class);
                                            startActivity(intent);

                                        }

                                        else{
                                            loadingBar.dismiss();
                                            Toast.makeText(Register.this, "Network Error or Something Went wrong Please Try Again", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }

                    else {
                        loadingBar.dismiss();
                        Toast.makeText(Register.this, "Your passwords are not matching.. Please enter Again ", Toast.LENGTH_SHORT).show();

                    }

                }

                else{
                    Toast.makeText(Register.this, "This " + phone + " Already Exists..", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(Register.this, "Please Try With Aother Phone Number ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}