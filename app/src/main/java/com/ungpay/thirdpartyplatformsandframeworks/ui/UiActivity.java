package com.ungpay.thirdpartyplatformsandframeworks.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;
import com.ungpay.thirdpartyplatformsandframeworks.ui.PhoneCard.EditTextWathcerActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.ViewLayoutTransation.ViewActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.alipayui.AlipayHomeActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.customKeyBoard.CustomKeyboard;
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
        findViewById(R.id.editText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UiActivity.this, EditTextWathcerActivity.class));
            }
        });
        findViewById(R.id.ViewShowHidden).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UiActivity.this, ViewActivity.class));
            }
        });
        findViewById(R.id.keyboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UiActivity.this, CustomKeyboard.class));
            }
        });

    }
}
