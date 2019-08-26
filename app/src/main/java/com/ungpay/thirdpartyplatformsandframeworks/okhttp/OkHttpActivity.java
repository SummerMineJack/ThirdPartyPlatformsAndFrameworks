package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.ungpay.thirdpartyplatformsandframeworks.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class OkHttpActivity extends AppCompatActivity implements RequestServerCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        findViewById(R.id.request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DeviceUtils.getSDKVersionCode() >= 23) {
                    getPhoneStats();
                } else {
                    try {
                        sendLogin();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * Dynamic permission application
     */
    private void getPhoneStats() {
        PermissionUtils.permission(new String[]{Manifest.permission.READ_PHONE_STATE})
                .rationale( new PermissionUtils.OnRationaleListener() {
                    @Override
                    public void rationale(ShouldRequest shouldRequest) {
                        DialogHelper.showRationaleDialog(shouldRequest);
                    }
                }).callback(new PermissionUtils.FullCallback() {
            @Override
            public void onGranted(List<String> permissionsGranted) {
                try {
                    sendLogin();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDenied(List<String> permissionsDeniedForever, List<String>
                    permissionsDenied) {
                if (!permissionsDeniedForever.isEmpty()) {
                    DialogHelper.showOpenAppSettingDialog();
                }
                getPhoneStats();
            }
        }).request();
    }
    private void sendLogin() throws JSONException {
        String randomStr = new DecimalFormat("000").format((int) (Math.random() * 999));
        long currentTime = System.currentTimeMillis();
        long serverDiffTime = 420L;
        HashMap<String, String> params = new HashMap<>();
        params.put("mobileCountryPrefix", "86");
        params.put("mobileNumber", "15871490754");
        params.put("customerPassword",
                Aes256.parseByte2HexStr(Aes256.encrypt("Hj123456",
                        SignUtil.createToken(serverDiffTime,
                                String.valueOf(currentTime),
                                randomStr))));
        JSONObject jsonObject = new JSONObject(params);
        PublicParameterBean publicParameterBean = SignUtil.setPublicParames(jsonObject.toString()
                , OkHttpActivity.this, serverDiffTime, randomStr, currentTime);
        JSONObject publicJsonObject = SignUtil.jsonParames(publicParameterBean);
        ServerRequset serverRequset = new ServerRequset(ServerInterfaceContant.appLogin4UserNameUserPwd, publicJsonObject);
        serverRequset.setRequestServerCallBack(this);
        serverRequset.post4Json();
    }

    private void sendRequest() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("clientTime", String.valueOf(System.currentTimeMillis()));
        ServerRequset serverRequset = new ServerRequset(attachHttpGetParams(ServerInterfaceContant.appGetTimeDifference, linkedHashMap), null);
        serverRequset.setRequestServerCallBack(this);
        serverRequset.get();
    }

    @Override
    public void Fail(String responseCode, String responseMessage, String responseData) {
        Log.e("~~", "responseCode:" + responseCode + " responseMessage:" + responseMessage + " responseData:" + responseData);
    }

    @Override
    public void Success(String successData) {
        try {
            JSONObject jsonObject = new JSONObject(successData);
            Log.e("~~", jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    /**
     * 为HttpGet 的 url 方便的添加多个name value 参数。
     *
     * @param url
     * @param params
     * @return
     */
    public static String attachHttpGetParams(String url, LinkedHashMap<String, String> params) {
        Iterator<String> keys = params.keySet().iterator();
        Iterator<String> values = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");
        for (int i = 0; i < params.size(); i++) {
            stringBuffer.append(keys.next() + "=" + values.next());
            if (i != params.size() - 1) {
                stringBuffer.append("&");
            }
        }

        return url + stringBuffer.toString();
    }
}
