package com.onurciner.fontchangenonfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Onur.Ciner on 4.01.2017.
 */

public class FEditText extends EditText {

    String font = null;
    Integer style = 0;

    public FEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FEditText, 0, 0);

        try {
            if (a != null && a.getString(R.styleable.FEditText_xfont) != null)
                font = a.getString(R.styleable.FEditText_xfont);
            style = a.getInteger(R.styleable.FEditText_xfontStyle, 0);
        } finally {
            a.recycle();
        }

        Typeface tf = null;

        if (font != null) {
            tf = Typeface.createFromAsset(context.getAssets(), font);
        }

        if (style == 0)
            this.setTypeface(tf, Typeface.NORMAL);
        else if (style == 1)
            this.setTypeface(tf, Typeface.ITALIC);
        else if (style == 2)
            this.setTypeface(tf, Typeface.BOLD);
        else if (style == 3)
            this.setTypeface(tf, Typeface.BOLD_ITALIC);
        else
            this.setTypeface(tf);

    }
}
