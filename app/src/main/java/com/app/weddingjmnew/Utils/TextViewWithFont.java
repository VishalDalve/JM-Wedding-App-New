package com.app.weddingjmnew.Utils;

import android.content.Context;
import android.util.AttributeSet;

import com.app.weddingjmnew.R;

/**
 * Created by vishal on 20/7/18.
 */
public class TextViewWithFont extends android.support.v7.widget.AppCompatTextView {


    public TextViewWithFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        android.graphics.Typeface fontsStyle = android.graphics.Typeface.createFromAsset(context.getAssets(), context.getString(R.string.typeface_bold_font));
        this.setTypeface(fontsStyle);

    }

    public TextViewWithFont(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        android.graphics.Typeface fontsStyle = android.graphics.Typeface.createFromAsset(context.getAssets(), context.getString(R.string.typeface_bold_font));
        this.setTypeface(fontsStyle);

    }

    public TextViewWithFont(Context context) {

        super(context);
        android.graphics.Typeface fontsStyle = android.graphics.Typeface.createFromAsset(context.getAssets(), context.getString(R.string.typeface_bold_font));
        this.setTypeface(fontsStyle);

    }

}