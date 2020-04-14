package com.ungpay.thirdpartyplatformsandframeworks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.OkGo.OkGoActivity;
import com.ungpay.thirdpartyplatformsandframeworks.UmnegTongji.BugActivity;
import com.ungpay.thirdpartyplatformsandframeworks.adapter.DemoListAdapter;
import com.ungpay.thirdpartyplatformsandframeworks.bluetooth.BlueToothActivity;
import com.ungpay.thirdpartyplatformsandframeworks.eventsbus.EventsBusMainActivity;
import com.ungpay.thirdpartyplatformsandframeworks.exoMedia.ExoMediaChooseActivity;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.view.MVPMainActivity;
import com.ungpay.thirdpartyplatformsandframeworks.okhttp.OkHttpActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.UiActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView demoList;
    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        demoList = findViewById(R.id.list_demo);
        demoList.setOnItemClickListener(this);
        initData();
        demoList.setAdapter(new DemoListAdapter(datas, MainActivity.this));
    }

    private void initData() {
        datas = new ArrayList<>();
        datas.add("Bugly");
        datas.add("OkHttp");
        datas.add("OkGo");
        datas.add("MVP");
        datas.add("ui");
        datas.add("ExoMedia");
        datas.add("EventBus");
        datas.add("BlueTooth");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, BugActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, OkHttpActivity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, OkGoActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, MVPMainActivity.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, UiActivity.class));
                break;
            case 5:
                startActivity(new Intent(MainActivity.this, ExoMediaChooseActivity.class));
                break;
            case 6:
                startActivity(new Intent(MainActivity.this, EventsBusMainActivity.class));
                break;
            case 7:
                startActivity(new Intent(MainActivity.this, BlueToothActivity.class));
                break;
        }
    }


}
