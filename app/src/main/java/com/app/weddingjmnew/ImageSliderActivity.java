package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

/**
 * Created by Vishal on 1/23/2018.
 */

public class ImageSliderActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    Context mcontext;
    Intent i;
    TextView title;
    String data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_slider_layout);

        mcontext = this;
        mDemoSlider = findViewById(R.id.slider);
        title = findViewById(R.id.title);


        // getting intent here -----------
        data = getIntent().getExtras().getString("Family", "");

        title.setText(data);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();


        //Switching data as per activity ----------------

        switch (data) {

            case "Family":

                file_maps.put("Parents", R.drawable.parents);
                file_maps.put("Cousins", R.drawable.cousins);
                file_maps.put("Brothers", R.drawable.brothers);

                break;

            case "Relatives":

                file_maps.put("Parents", R.drawable.parents);
                file_maps.put("Cousins", R.drawable.cousins);
                file_maps.put("Brothers", R.drawable.brothers);

                break;

            case "Friends":

                file_maps.put("College Friends", R.drawable.friends1);
                file_maps.put("School Friends", R.drawable.friends2);
                file_maps.put("Office Friends", R.drawable.friends3);

                break;

            case "Mehandi":

                file_maps.put("College Friends", R.drawable.friends1);


                break;

            case "Haldi":

                file_maps.put("College Friends", R.drawable.friends1);
//                file_maps.put("School Friends", R.drawable.friends2);
//                file_maps.put("Office Friends", R.drawable.friends3);

                break;

            case "Wedding":

                file_maps.put("College Friends", R.drawable.friends1);
//                file_maps.put("School Friends", R.drawable.friends2);
//                file_maps.put("Office Friends", R.drawable.friends3);

                break;

            case "After":

                file_maps.put("College Friends", R.drawable.friends1);
//                file_maps.put("School Friends", R.drawable.friends2);
//                file_maps.put("Office Friends", R.drawable.friends3);

                break;

        }

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

    }

    @Override
    protected void onStop() {
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

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
