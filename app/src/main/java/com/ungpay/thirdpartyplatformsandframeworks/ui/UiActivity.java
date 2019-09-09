package com.ungpay.thirdpartyplatformsandframeworks.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ungpay.thirdpartyplatformsandframeworks.R;
import com.ungpay.thirdpartyplatformsandframeworks.ui.alipayui.AlipayHomeActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.fonts.FontsActivity;

public class UiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        findViewById(R.id.alipay_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UiActivity.this, AlipayHomeActivity.class));
            }
        });
        findViewById(R.id.fonts_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(UiActivity.this, FontsActivity.class));
            }
        });
    }
}
