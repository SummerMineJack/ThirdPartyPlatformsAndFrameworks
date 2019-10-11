package com.ungpay.thirdpartyplatformsandframeworks.ui.ViewLayoutTransation;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;

public class ViewActivity extends AppCompatActivity {

    private LinearLayout contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        contents = findViewById(R.id.contents);
        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contents.setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.hidden).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutTransition transition = new LayoutTransition();
                transition.enableTransitionType(LayoutTransition.DISAPPEARING);
                contents.setLayoutTransition(transition);
                contents.setVisibility(View.GONE);
            }
        });
    }
}
