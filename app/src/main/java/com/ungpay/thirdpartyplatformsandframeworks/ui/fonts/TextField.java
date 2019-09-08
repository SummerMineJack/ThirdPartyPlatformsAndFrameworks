package com.ungpay.thirdpartyplatformsandframeworks.ui.fonts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ungpay.thirdpartyplatformsandframeworks.R;

/**
 * Created by chris on 17/03/15.
 * For Calligraphy.
 */
@SuppressLint("AppCompatCustomView")
public class TextField extends TextView {

    public TextField(final Context context, final AttributeSet attrs) {
        super(context, attrs, R.attr.textFieldStyle);
    }

}
