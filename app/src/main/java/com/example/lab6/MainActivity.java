package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
//public static final String Mes="my message";
// Make sure to use the FloatingActionButton for all the FABs
    FloatingActionButton mAddFab, mAddAlarmFab, mAddPersonFab,feedbacktab,contacttab;

    // These are taken to make visible and invisible along with FABs
//    TextView addAlarmActionText, addPersonActionText;

    // to check whether sub FAB buttons are visible or not.
    Boolean isAllFabsVisible;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //Log.i(Mes,"Oncreate method");
//        setContentView(R.layout.activity_main);
//        //for getting the text from the user name
//        Intent i=getIntent();
//        String s=i.getStringExtra("hello");
//        StringBuffer sbuff=new StringBuffer();
//        sbuff.append(s).append(", ");
//        sbuff.append("Welcome to my app");
//        System.out.println(s);
//        TextView tv2=(TextView)findViewById(R.id.tv2);
//        tv2.setText(sbuff);
//    }
    @Override
    protected  void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(),"Resuming App",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected  void onStart()
    {
        super.onStart();
        Toast.makeText(getApplicationContext(),"Starting App",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected  void onPause()
    {
        super.onPause();
        Toast.makeText(getApplicationContext(),"Pausing App",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected  void onStop()
    {
        super.onStop();
        Toast.makeText(getApplicationContext(),"Stopping App",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected  void  onRestart()
    {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"Restarting App",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"Destroyed App",Toast.LENGTH_SHORT).show();

    }

    public void furniList(View v)
    {
        //ImageView imv1=(ImageView)findViewById(R.id.iv1);
        Intent i1 = new Intent(this, furnitures.class);
        startActivity(i1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.i(Mes,"Oncreate method");
        setContentView(R.layout.activity_main);
        //for getting the text from the user name
        Intent i=getIntent();
        String s=i.getStringExtra("hello");
        StringBuffer sbuff=new StringBuffer();
        sbuff.append(s).append(", ");
        sbuff.append("Welcome to my app");
        System.out.println(s);
        TextView tv2=(TextView)findViewById(R.id.tv2);
        tv2.setText(sbuff);
//        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register all the FABs with their IDs This FAB button is the Parent
        mAddFab = findViewById(R.id.add_fab);

        // FAB button
        mAddAlarmFab = findViewById(R.id.add_alarm_fab);
        mAddPersonFab = findViewById(R.id.add_person_fab);
        feedbacktab=findViewById(R.id.feedback);
        contacttab=findViewById(R.id.contact);


        // Also register the action name text, of all the FABs.
//        addAlarmActionText = findViewById(R.id.add_alarm_action_text);
//        addPersonActionText = findViewById(R.id.add_person_action_text);

        // Now set all the FABs and all the action name texts as GONE
        mAddAlarmFab.setVisibility(View.GONE);
        mAddPersonFab.setVisibility(View.GONE);
        feedbacktab.setVisibility(View.GONE);
        contacttab.setVisibility(View.GONE);
//        addAlarmActionText.setVisibility(View.GONE);
//        addPersonActionText.setVisibility(View.GONE);

        // make the boolean variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false;

        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab.setOnClickListener(view -> {
            if (!isAllFabsVisible) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                mAddAlarmFab.show();
                mAddPersonFab.show();
                feedbacktab.show();
                contacttab.show();
//                addAlarmActionText.setVisibility(View.VISIBLE);
//                addPersonActionText.setVisibility(View.VISIBLE);

                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = true;
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                mAddAlarmFab.hide();
                mAddPersonFab.hide();
                feedbacktab.hide();
                contacttab.hide();
//                addAlarmActionText.setVisibility(View.GONE);
//                addPersonActionText.setVisibility(View.GONE);

                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                isAllFabsVisible = false;
            }
        });
        // below is the sample action to handle add person FAB. Here it shows simple Toast msg.
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddPersonFab.setOnClickListener(
                view -> Toast.makeText(MainActivity.this, "Person Added", Toast.LENGTH_SHORT
                ).show());

        // below is the sample action to handle add alarm FAB. Here it shows simple Toast msg
        // The Toast will be shown only when they are visible and only when user clicks on them
        mAddAlarmFab.setOnClickListener(
                view -> Toast.makeText(MainActivity.this, "Alarm Added", Toast.LENGTH_SHORT
                ).show());
        feedbacktab.setOnClickListener(
                view -> startActivity(new Intent(this,feedback.class)));
        contacttab.setOnClickListener(
                view -> startActivity(new Intent(this,contactus.class)));
    }

}