package com.ia.android.akinasport.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ia.android.akinasport.R;

/**
 * Created by Arnaud on 28/04/2016.
 */
public class AkinasportTextViewBig extends TextView
{
    public AkinasportTextViewBig(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public AkinasportTextViewBig(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public AkinasportTextViewBig(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null)
        {
            Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), getContext().getString(R.string.fontLemonMilkName));
            setTypeface(typeface);
            setTextSize(18);
        }
    }
}