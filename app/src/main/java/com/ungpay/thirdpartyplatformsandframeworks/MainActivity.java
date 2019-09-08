package com.ungpay.thirdpartyplatformsandframeworks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.OkGo.OkGoActivity;
import com.ungpay.thirdpartyplatformsandframeworks.UmnegTongji.BugActivity;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.view.MVPMainActivity;
import com.ungpay.thirdpartyplatformsandframeworks.okhttp.OkHttpActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.UiActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bugly).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BugActivity.class));
            }
        });
        findViewById(R.id.okhttp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OkHttpActivity.class));
            }
        });
        findViewById(R.id.mvp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MVPMainActivity.class));
            }
        });
        findViewById(R.id.OkGo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OkGoActivity.class));
            }
        });
        findViewById(R.id.ui).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UiActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
