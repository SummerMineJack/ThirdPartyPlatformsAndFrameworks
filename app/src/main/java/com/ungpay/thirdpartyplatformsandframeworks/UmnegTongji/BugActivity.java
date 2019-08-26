package com.ungpay.thirdpartyplatformsandframeworks.UmnegTongji;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.ArrayList;

public class BugActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugly);
        findViewById(R.id.test_java_bug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        findViewById(R.id.test_anr_bug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
