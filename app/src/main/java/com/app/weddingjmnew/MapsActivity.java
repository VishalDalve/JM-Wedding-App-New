package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by jmtec on 1/22/2018.
 */

public class MapsActivity extends AppCompatActivity {


    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_layout);

        mcontext = this;

        TextView opnmap = findViewById(R.id.tv_open_map);

        opnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 18.5155346, 73.7836165);
                String geoUri = "http://maps.google.com/maps?q=loc:" + 18.5155346 + "," + 73.7836165 + " (" + "Manyavar" + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                mcontext.startActivity(intent);

            }
        });


    }
}