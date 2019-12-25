package com.ungpay.thirdpartyplatformsandframeworks.eventsbus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.BusUtils;
import com.ungpay.thirdpartyplatformsandframeworks.R;

public class EventBusSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_second);
        findViewById(R.id.button).setOnClickListener(v -> {
            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setStuClass("10对4");
            studentDetail.setStuName("HuangJian");
            BusUtils.post("student", studentDetail);

            StudentDetail studentDetail1 = new StudentDetail();
            studentDetail1.setStuClass("10对4 2");
            studentDetail1.setStuName("HuangJian2");
            BusUtils.post("students", studentDetail1);
            finish();
        });
    }
}
