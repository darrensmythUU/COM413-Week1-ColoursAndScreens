package com.example.coloursandscreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button btnColour;
    private Button btnNextScreen;
    private ConstraintLayout mainLayout;
    private boolean isTeal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnColour = findViewById(R.id.btnColour);
        btnNextScreen = findViewById(R.id.btnNextScreen);
        mainLayout = findViewById(R.id.mainLayout);

        btnColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Safely grab the activity context from the clicked view
                Context context = view.getContext();

                if (isTeal) {
                    // 1. Setting background colour using contextCompat
                    mainLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.my_orange));

                    // 2. Setting background tint correctly
                    btnColour.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.white));

                    // 3. Setting text colour by resolving the resource ID first
                    btnColour.setTextColor(ContextCompat.getColor(context, R.color.black));
                }
                else {
                    mainLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.my_teal));

                    btnColour.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.black));

                    btnColour.setTextColor(ContextCompat.getColor(context, R.color.white));
                }
                isTeal = !isTeal;
            }
        });

        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}