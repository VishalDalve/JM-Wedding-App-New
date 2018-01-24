package com.app.weddingjmnew;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.weddingjmnew.Utils.Util;
import com.squareup.picasso.Picasso;

/**
 * Created by jmtec on 1/22/2018.
 */

public class UserActivity extends AppCompatActivity {


    Context mcontext;
    private TextView name, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_layout);

        mcontext = this;

        name = findViewById(R.id.tv_name);
        mail = findViewById(R.id.tv_email);
        ImageView imge = findViewById(R.id.iv_email);

        SharedPreferences prefs = getSharedPreferences(Util.PREFS_LOGIN_DATA, MODE_PRIVATE);
        String restoredText = prefs.getString("name", null);
        if (restoredText != null) {
            String nme = prefs.getString("name", null);//"No name defined" is the default value.
            String email = prefs.getString("email", null);
            String img = prefs.getString("image", null);

            name.setText(nme);
            mail.setText(email);

            Picasso.with(mcontext)
                    .load(img)
                    .placeholder(R.drawable.user)
                    .resize(250, 250)
                    .centerCrop()
                    .into(imge);
        }

    }
}