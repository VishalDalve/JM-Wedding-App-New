package com.app.weddingjmnew;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jmtec on 1/22/2018.
 */

public class GuestActivity extends AppCompatActivity {


    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_layout);

        mcontext = this;

    }
}