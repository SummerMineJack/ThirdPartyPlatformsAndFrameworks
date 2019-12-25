package com.ungpay.thirdpartyplatformsandframeworks.eventsbus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ApiUtils;
import com.blankj.utilcode.util.BusUtils;
import com.ungpay.thirdpartyplatformsandframeworks.R;


public class EventsBusMainActivity extends AppCompatActivity {


    TextView textView;
    TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_bus_main);
        textView = findViewById(R.id.tv_bus);
        textView1=findViewById(R.id.tv_bus_one);
        findViewById(R.id.btn_jump).setOnClickListener(v -> {
            startActivity(new Intent(this, EventBusSecondActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        BusUtils.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusUtils.unregister(this);
    }
    @BusUtils.Bus(tag = "student")
    public void getStudentDetail(StudentDetail studentDetail) {
        textView.setText("姓名：" + studentDetail.getStuName() + " 年级：" + studentDetail.getStuClass());
    }
    @BusUtils.Bus(tag = "students")
    public void getMore(StudentDetail studentDetail) {
        textView1.setText("姓名：" + studentDetail.getStuName() + " 年级：" + studentDetail.getStuClass());
    }
}
