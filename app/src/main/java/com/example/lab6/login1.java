package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

public class login1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
    }
    public void signIn(View view) {
        //user name
        EditText t1 = (EditText) findViewById(R.id.username);
        //String value=String.valueOf(t1.getText());
        String value = t1.getText().toString();

        //password
        EditText t2 = (EditText) findViewById(R.id.password);
        //String value2=String.valueOf(t2.getText());
        String value2 = t2.getText().toString();
        //checking condition
        Log.i("username",value);
        Log.i("password",value2);
        if (value.equals("christy") && value2.equals("alex")) {
            Intent i1 = new Intent(this, MainActivity.class);
            i1.putExtra("username", value);
            startActivity(i1);
        } else {
            Log.i("Not valid credentials", "Oncreate method");
        }
    }
    public void sentMessageIn(View v)
    {
        EditText et=(EditText)findViewById(R.id.username);
        String st=String.valueOf(et.getText());
        System.out.println(st);
        Intent intent1=new Intent(this,MainActivity.class);
        intent1.putExtra("hello",st);
        startActivity(intent1);
    }




}
