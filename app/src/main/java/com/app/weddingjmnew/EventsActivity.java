package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by jmtec on 1/22/2018.
 */

public class EventsActivity extends AppCompatActivity {

CardView mehndi,haldi,wedding,afterwedding;
    Context mcontext;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);
        mcontext = this;

        mehndi = findViewById(R.id.card_mehandi);
        haldi = findViewById(R.id.card_haldi);
        wedding = findViewById(R.id.card_wedding);
        afterwedding = findViewById(R.id.card_after);

        mehndi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, ImageSliderActivity.class);
                i.putExtra("Family", "Mehandi");
                startActivity(i);

            }
        });

        haldi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, ImageSliderActivity.class);
                i.putExtra("Family", "Haldi");
                startActivity(i);

            }
        });

        wedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, ImageSliderActivity.class);
                i.putExtra("Family", "Wedding");
                startActivity(i);

            }
        });

        afterwedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, ImageSliderActivity.class);
                i.putExtra("Family", "After");
                startActivity(i);

            }
        });
    }
}