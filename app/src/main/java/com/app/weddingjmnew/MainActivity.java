package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout groom, bride, maps;
    Intent i;

    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcontext = this;

        groom = findViewById(R.id.ll_groom);
        bride = findViewById(R.id.ll_bride);
        maps = findViewById(R.id.ll_maps);


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
}
