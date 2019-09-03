package com.ungpay.thirdpartyplatformsandframeworks.OkGo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.ungpay.thirdpartyplatformsandframeworks.R;

import java.util.List;

public class OkGoActivity extends AppCompatActivity implements OnClickListener {

    private Button btnGoSendRequest;
    private TextView responsetv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_go);
        btnGoSendRequest = findViewById(R.id.sendRequest);
        responsetv = findViewById(R.id.response);
        btnGoSendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sendRequest:
                sendRequest();
                break;
        }
    }

    private void sendRequest() {
        OkGo.<ServerResponse<List<ServerModel>>>get("http://v.juhe.cn/boxoffice/rank")
                .params("key", "e79ba85d9c205beeeb4f7e3d4c21e264")
                .tag(this)
                .execute(new DialogCallback<ServerResponse<List<ServerModel>>>(this) {
                    @Override
                    public void onSuccess(Response<ServerResponse<List<ServerModel>>> response) {
                        Log.e("~", response.body().resultcode);
                    }
                });
    }
}
