package com.ia.android.akinasport.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.renderscript.BaseObj;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ia.android.akinasport.R;

/**
 * Created by Arnaud on 17/03/2016.
 */
public class AkinasportTextView extends TextView
{
    public AkinasportTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public AkinasportTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public AkinasportTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null)
        {
            Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), getContext().getString(R.string.fontFuturaName));
            setTypeface(typeface);
        }
    }
}
