package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class furnitures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furnitures);

    }
    public void shareto(View v)
    {
        Intent in1=new Intent(this,contactus.class);
        startActivity(in1);

    }
    public void feedback(View v)
    {
        Intent in2=new Intent(this,feedback.class);
        startActivity(in2);
    }
}