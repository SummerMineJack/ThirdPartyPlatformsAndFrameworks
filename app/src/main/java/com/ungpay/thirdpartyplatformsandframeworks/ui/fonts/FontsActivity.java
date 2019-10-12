package com.ungpay.thirdpartyplatformsandframeworks.ui.fonts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FontsActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fonts);
    }
}
