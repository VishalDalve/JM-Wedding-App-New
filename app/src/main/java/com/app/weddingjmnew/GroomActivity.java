package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static com.app.weddingjmnew.Utils.Util.PREFS_LOGIN_DATA;

/**
 * Created by vishal on 1/22/2018.
 */

public class GroomActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    private SliderLayout mDemoSlider;
    Context mcontext;
    LinearLayout events, family, friends, relatives, guest;
    Intent i;
    String data;
    HashMap<String, String> file_maps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.groom_layout);

        mcontext = this;
        file_maps = new HashMap<String, String>();


        mDemoSlider = findViewById(R.id.slider);
        events = findViewById(R.id.ll_events);
        family = findViewById(R.id.ll_family);
        friends = findViewById(R.id.ll_friends);
        relatives = findViewById(R.id.ll_relatives);
        guest = findViewById(R.id.ll_guest);

        // getting intent here -----------
        data = getIntent().getExtras().getString("type", "");


        final SharedPreferences acid_pref = mcontext.getSharedPreferences(PREFS_LOGIN_DATA, mcontext.MODE_PRIVATE);

        String alldata = acid_pref.getString("alldata", null);
        Log.d("All_DATA_Image", alldata);


        //checking is bride or groom -----------------------
        parseResult(data, alldata);


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

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(mcontext, GuestActivity.class);
                i.putExtra("Family", "Relatives");
                startActivity(i);

            }
        });


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


    //parsed all server wedding data ----------------------------
    private void parseResult(String family, String result) {

        try {
            JSONObject response = new JSONObject(result);

            String msg = response.getString("result");
            Log.d("Result", msg);

            JSONArray posts = response.optJSONArray("data");

            if (posts != null) {

                for (int i = 0; i < posts.length(); i++) {
                    int flag = 0;
                    JSONObject post = posts.optJSONObject(i);

                    String msgg = post.optString("TITLE");
                    String img = post.optString("PATH");
                    String category = post.optString("STATUS");
                    String type = post.optString("TYPE");

//                    Log.d("Title", msgg);
//                    Log.d("Imag", img);
//                    Log.d("Category", category);
//                    Log.d("Type", type);

                    // adding data appropriatly as activity clicked -------------------------

                    if (family.equalsIgnoreCase(type) && category.equalsIgnoreCase("slider")) {

                        file_maps.put(msgg, img);
                        Log.d("ResultINSlider", img);

                    }


                    //  FeedItem item = new FeedItem();
//                    item.setApp_offer_id(post.optString("app_offers_id"));
//                    item.setApp_name(post.optString("title"));
//                    "ID": "5",
//                            "USER_ID": "ikrams290@gmail.com",
//                            "TITLE": "family one",
//                            "PATH": "uploads/f1.jpg",
//                            "STATUS": "family",
//                            "TYPE": "bride",

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}