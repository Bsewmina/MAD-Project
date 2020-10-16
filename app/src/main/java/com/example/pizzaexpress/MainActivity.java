package com.example.pizzaexpress;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layoutobj = findViewById(R.id.main);

        layoutobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(getApplicationContext(),Login.class);
                startActivity(obj);
            }
        });


    }
}