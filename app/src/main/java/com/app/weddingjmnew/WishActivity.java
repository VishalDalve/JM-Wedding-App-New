package com.app.weddingjmnew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.Telephony.BaseMmsColumns.SUBJECT;

/**
 * Created by jmtec on 1/22/2018.
 */

public class WishActivity extends AppCompatActivity {


    Context mcontext;
    EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishes_layout);

        mcontext = this;

       msg = findViewById(R.id.et_msg);
        TextView sendmail = findViewById(R.id.tv_sendmail);

        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"vishal@websvento.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Wedding Wishes");
                intent.putExtra(Intent.EXTRA_TEXT, msg.getText().toString());

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Select Email Sending App :"));

            }
        });

    }
}