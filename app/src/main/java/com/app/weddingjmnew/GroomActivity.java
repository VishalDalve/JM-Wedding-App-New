package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

/**
 * Created by vishal on 1/22/2018.
 */

public class GroomActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    private SliderLayout mDemoSlider;
    Context mcontext;
    LinearLayout events, family,friends,relatives;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groom_layout);

        mcontext = this;

        mDemoSlider = findViewById(R.id.slider);
        events = findViewById(R.id.ll_events);
        family = findViewById(R.id.ll_family);
        friends = findViewById(R.id.ll_friends);
        relatives = findViewById(R.id.ll_relatives);
       // guest = findViewById(R.id.ll_guest);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal", R.drawable.bride);
        file_maps.put("Big Bang Theory", R.drawable.groom);
        file_maps.put("House of Cards", R.drawable.bride);
        file_maps.put("Game of Thrones", R.drawable.groom);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(3000);
        mDemoSlider.addOnPageChangeListener(this);


        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, EventsActivity.class);
                startActivity(i);
            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, ImageSliderActivity.class);
                i.putExtra("Family", "Family");
                startActivity(i);

            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, ImageSliderActivity.class);
                i.putExtra("Family", "Friends");
                startActivity(i);

            }
        });

        relatives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, ImageSliderActivity.class);
                i.putExtra("Family", "Relatives");
                startActivity(i);

            }
        });

//        guest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                i = new Intent(mcontext, GuestActivity.class);
//                i.putExtra("Family", "Relatives");
//                startActivity(i);
//
//            }
//        });


    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}