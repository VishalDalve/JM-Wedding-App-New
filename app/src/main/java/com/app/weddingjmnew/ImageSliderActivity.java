package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

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
 * Created by Vishal on 1/23/2018.
 */

public class ImageSliderActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;
    Context mcontext;
    Intent i;
    TextView title;
    String data;
    HashMap<String, String> file_maps;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_slider_layout);

        mcontext = this;
        mDemoSlider = findViewById(R.id.slider);
        title = findViewById(R.id.title);


        final SharedPreferences acid_pref = mcontext.getSharedPreferences(PREFS_LOGIN_DATA, mcontext.MODE_PRIVATE);

        String alldata = acid_pref.getString("alldata", null);
        Log.d("All_DATA_Image", alldata);


        // getting intent here -----------
        data = getIntent().getExtras().getString("Family", "");

        title.setText(data);

        file_maps = new HashMap<String, String>();


        //Switching data as per activity ----------------

        switch (data) {

            case "Family":

                parseResult("Family", alldata);


                break;

            case "Relatives":

                parseResult("Relatives", alldata);

                break;

            case "Friends":
                parseResult("Friends", alldata);

                break;

            case "Mehandi":
                parseResult("Mehandi", alldata);

                break;

            case "Haldi":
                parseResult("Haldi", alldata);

                break;

            case "Wedding":
                parseResult("Wedding", alldata);

                break;

            case "After":
                parseResult("pooja", alldata);

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
        mDemoSlider.setDuration(8000);
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

                    if (family.equalsIgnoreCase(category)) {

                        file_maps.put(msgg, img);
                        Log.d("ResultINLoop", img);

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
