package com.onurciner.fontchangenonfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Onur.Ciner on 4.01.2017.
 */

public class FButton extends Button {

    String font = null;
    Integer style = 0;

    public FButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FButton, 0, 0);

            try {
                if (a != null && a.getString(R.styleable.FButton_xfont) != null)
                    font = a.getString(R.styleable.FButton_xfont);
                style = a.getInteger(R.styleable.FButton_xfontStyle, 0);
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

}