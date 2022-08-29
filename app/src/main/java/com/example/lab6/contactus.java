package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.util.Calendar;

public class contactus extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
    }
    public void sentemail(View v)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
        //emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);

        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jan@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris
        startActivity(emailIntent);

    }
    public void addcalender(View v)
    {
        // Event is on January 23, 2021 -- from 7:30 AM to 10:30 AM.
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2021, 0, 23, 7, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2021, 0, 23, 10, 30);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
        startActivity(calendarIntent);

    }
    public void openBroser(View v)
    {
        EditText et=(EditText)findViewById(R.id.url);
        String url = et.getText().toString();
        Log.i("url parsed", url);
        Uri u= Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,u);
        //intent.setData(Uri.parse("https://www.geeksforgeeks.org"));
        Intent intent1=Intent.createChooser(intent,"open with");
        // intent.setData(u);
        startActivity(intent1);
    }
    public void dial(View v)
    {
        Uri number = Uri.parse("tel:8943478078");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        callIntent.putExtra(Intent.EXTRA_PHONE_NUMBER,number);
        startActivity(callIntent);
    }
    public void openMap(View v)
    {
        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
// Or map point based on latitude/longitude
// Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }
    public  void opencamera(View v)
    {
        Intent open_camera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(open_camera,100);

    }
}