package com.ungpay.thirdpartyplatformsandframeworks.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;
import com.ungpay.thirdpartyplatformsandframeworks.adapter.DemoListAdapter;
import com.ungpay.thirdpartyplatformsandframeworks.ui.PhoneCard.EditTextWathcerActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.ViewLayoutTransation.ViewActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.alipayui.AlipayHomeActivity;
import com.ungpay.thirdpartyplatformsandframeworks.ui.customKeyBoard.CustomKeyboard;
import com.ungpay.thirdpartyplatformsandframeworks.ui.fonts.FontsActivity;

import java.util.ArrayList;

public class UiActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView demoList;
    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        demoList = findViewById(R.id.list_demo);
        demoList.setOnItemClickListener(this);
        initData();
        demoList.setAdapter(new DemoListAdapter(datas, UiActivity.this));

    }

    private void initData() {
        datas = new ArrayList<>();
        datas.add("仿支付宝首页滑动缩放");
        datas.add("字体");
        datas.add("editText");
        datas.add("ViewShowHidden");
        datas.add("keyboard");
        datas.add("SimpleExoPlayerTimeBar");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(UiActivity.this, AlipayHomeActivity.class));
                break;
            case 1:
                startActivity(new Intent(UiActivity.this, FontsActivity.class));
                break;
            case 2:
                startActivity(new Intent(UiActivity.this, EditTextWathcerActivity.class));
                break;
            case 3:
                startActivity(new Intent(UiActivity.this, ViewActivity.class));
                break;
            case 4:
                startActivity(new Intent(UiActivity.this, CustomKeyboard.class));
                break;
            case 5:
                startActivity(new Intent(UiActivity.this, SimpleExoPlayerTimeBar.class));
                break;
        }
    }
}
