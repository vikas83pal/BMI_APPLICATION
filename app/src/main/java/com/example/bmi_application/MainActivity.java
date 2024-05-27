package com.example.bmi_application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText wt,hf,hi;
        Button btn;
        TextView res;


        wt=findViewById(R.id.wt);
        hf=findViewById(R.id.hf);
        hi=findViewById(R.id.hi);
        btn=findViewById(R.id.btn);
        res=findViewById(R.id.res);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int w= Integer.parseInt(wt.getText().toString());
               int ft=Integer.parseInt(hf.getText().toString());
               int in=Integer.parseInt(hi.getText().toString());

                int totalInches = ft * 12 + in;
                double totalCm = totalInches * 2.54; // Corrected conversion factor from inches to centimeters
                double totalM = totalCm / 100; // Convert cm to meters
                double totalHeightSquared = totalM * totalM; // Square of height in meters

                double bmi = w / totalHeightSquared; // Calculate BMI

                if (bmi > 25) {
                    res.setText("You Are Overweight");
                } else if (bmi < 18) {
                    res.setText("You Are Underweight");
                } else {
                    res.setText("You Are Healthy");
                }


            }
        });



    }
}