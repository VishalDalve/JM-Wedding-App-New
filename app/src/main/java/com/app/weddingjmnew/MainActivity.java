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

public class MainActivity extends AppCompatActivity {

    LinearLayout groom, bride, maps;
    Intent i;
    ImageView lft, rgt;
    Context mcontext;

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


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.ltor);
        rgt.startAnimation(animation);
        Animation animationn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rtof);
        lft.startAnimation(animationn);


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
