package com.example.arpit.getwel;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

public class HindiTextView extends AppCompatTextView {
    public HindiTextView(Context context) {
        super(context);
        initTypeFace(context);
    }

    public HindiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeFace(context);
    }

    public HindiTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeFace(context);
    }
    public void initTypeFace(Context context)
    {
        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"Kruti_Dev_010.ttf");
    }
}
