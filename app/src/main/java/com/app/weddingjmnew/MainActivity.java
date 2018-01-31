package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.weddingjmnew.Utils.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cn.iwgang.countdownview.CountdownView;

import static com.app.weddingjmnew.Utils.Util.PREFS_LOGIN_DATA;

public class MainActivity extends AppCompatActivity {

    LinearLayout groom, bride, maps, user, wish;
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
        user = findViewById(R.id.ll_user);
        wish = findViewById(R.id.ll_wishes);

        lft = findViewById(R.id.iv_lft);
        rgt = findViewById(R.id.iv_rgt);

        mCvCountdownViewTest21 = findViewById(R.id.cv_countdownViewTest21);
        mCvCountdownViewTest21.setTag("test21");

        new PackagesSent().execute();


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
                i.putExtra("type", "groom");
                startActivity(i);

            }
        });

        bride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = new Intent(mcontext, GroomActivity.class);
                i.putExtra("type", "bride");
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

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = new Intent(mcontext, UserActivity.class);
                startActivity(i);

            }
        });

        wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i = new Intent(mcontext, WishActivity.class);
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

        long time21 = (long) elapsedDays * 24 * 60 * 60 * 1000;
        mCvCountdownViewTest21.start(time21);
    }

    //app opened task ---------------------------------------------------
    class PackagesSent extends AsyncTask<String, Void, Void> {

        final SharedPreferences.Editor editor = mcontext.getSharedPreferences(PREFS_LOGIN_DATA, mcontext.MODE_PRIVATE).edit();
        //getting user id of user from shared pref ---------
        // final SharedPreferences acid_pref = mcontext.getSharedPreferences(PREFS_LOGIN_DATA, mcontext.MODE_PRIVATE);

//        String alldata = acid_pref.putString("alldata", null);
//        // Log.d("userid_main",user_id);

        @Override
        protected Void doInBackground(String... params) {
            try {

                URL url = new URL("http://10.10.10.53/wedding_websevices.php?id=ikrams290@gmail.com");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                String encryptedRequest = null;

                String urlParameters = "data=" + encryptedRequest;
                // Log.d("URL params App_Opened ", urlParameters);

                connection.setRequestMethod("POST");
                connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
                connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");
                connection.setDoOutput(true);
                DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());
                dStream.writeBytes(urlParameters);
                dStream.flush();
                dStream.close();
                // int responseCode = connection.getResponseCode();
                final StringBuilder output = new StringBuilder();

                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = "";
                StringBuilder responseOutput = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    responseOutput.append(line);
                }
                br.close();

                output.append(responseOutput.toString());

                String s = output.toString();

                editor.putString("alldata", s);
                editor.apply();

                // parseResult(s);

                Log.d("PACKAGE_SENT", s);


            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }


    }
}
