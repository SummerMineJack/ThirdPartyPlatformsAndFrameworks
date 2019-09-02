package com.ungpay.thirdpartyplatformsandframeworks.OkGo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;
import com.ungpay.thirdpartyplatformsandframeworks.R;

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
        OkGo.<String>get("http://v.juhe.cn/joke/content/list.php?time=1418816972&key=a51a682a669992d512ee34bc9f0d64da").tag(this)
                .execute(new AbsCallback<String>() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("~~onSuccess", response.body() + "");
                    }

                    @Override
                    public String convertResponse(okhttp3.Response response) {
                        Log.e("~~convertResponse", response.code() + "");
                        return null;
                    }
                });
    }
}
