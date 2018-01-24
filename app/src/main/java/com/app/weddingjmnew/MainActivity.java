package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.iwgang.countdownview.CountdownView;

public class MainActivity extends AppCompatActivity {

    LinearLayout groom, bride, maps;
    Intent i;
    ImageView lft, rgt;
    Context mcontext;
    CountdownView mCvCountdownViewTest21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcontext = this;

        groom = findViewById(R.id.ll_groom);
        bride = findViewById(R.id.ll_bride);
        maps = findViewById(R.id.ll_maps);

        lft = findViewById(R.id.iv_lft);
        rgt = findViewById(R.id.iv_rgt);

        mCvCountdownViewTest21 = findViewById(R.id.cv_countdownViewTest21);
        mCvCountdownViewTest21.setTag("test21");


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.ltor);
        rgt.startAnimation(animation);
        Animation animationn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rtof);
        lft.startAnimation(animationn);


        //DateTimeUtils obj = new DateTimeUtils();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");

        Calendar c = Calendar.getInstance();
//        System.out.println("Current time => "+c.getTime());

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = simpleDateFormat.format(c.getTime());


        try {
            Date date1 = simpleDateFormat.parse("18/02/2018 12:30:10");
            Date date2 = simpleDateFormat.parse(formattedDate);

            printDifference(date2, date1);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        groom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = new Intent(mcontext, GroomActivity.class);
                startActivity(i);

            }
        });

        bride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = new Intent(mcontext, GroomActivity.class);
                startActivity(i);

            }
        });

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = new Intent(mcontext, MapsActivity.class);
                startActivity(i);

            }
        });

    }

    //1 minute = 60 seconds
    //1 hour = 60 x 60 = 3600
    //1 day = 3600 x 24 = 86400
    public void printDifference(Date startDate, Date endDate) {
        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);

        //long time21 = (long) elapsedDays * 24 * 60 * 60 * 1000;
        mCvCountdownViewTest21.start(different);
    }

}
