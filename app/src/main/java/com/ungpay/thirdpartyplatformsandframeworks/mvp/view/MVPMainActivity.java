package com.ungpay.thirdpartyplatformsandframeworks.mvp.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ungpay.thirdpartyplatformsandframeworks.R;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.model.bean.GetServerTimeDiffBean;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.presenter.impl.GetServerTimeDiffImpl;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.view.view.GetServerTimeDiffView;

public class MVPMainActivity extends AppCompatActivity implements GetServerTimeDiffView {

    private TextView textView;
    private Dialog dialog;
    private GetServerTimeDiffImpl getServerTimeDiff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpmain);
        getServerTimeDiff = new GetServerTimeDiffImpl(this);
        dialog=new ProgressDialog(this);
        dialog.setTitle("获取数据中");
        textView = findViewById(R.id.result);
        findViewById(R.id.getServerTimeDiff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getServerTimeDiff();
            }
        });
    }

    private void getServerTimeDiff() {
        getServerTimeDiff.getServerTimeDiff();
    }

    @Override
    public void setArticleInfo(GetServerTimeDiffBean articleInfo) {
        textView.setText(articleInfo.getTimeDiff() + "");
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "网络出错", Toast.LENGTH_SHORT).show();
    }
}
