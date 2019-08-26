package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Response;

import static java.net.HttpURLConnection.HTTP_OK;

public class ServerRequset {

    private String url;
    private RequestServerCallBack requestServerCallBack;
    private JSONObject jsonObject;

    public void setRequestServerCallBack(RequestServerCallBack requestServerCallBack) {
        this.requestServerCallBack = requestServerCallBack;
    }

    public ServerRequset(String url, JSONObject jsonObject) {
        this.url = url;
        this.jsonObject = jsonObject;
    }

    public void get() {
        HttpUtils.getInstance().get(url, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                if (requestServerCallBack != null) {
                    requestServerCallBack.Fail("0", e.getMessage(), "");
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                if (response.code() == HTTP_OK) {
                    if (requestServerCallBack != null) {
                        try {
                            requestServerCallBack.Success(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if (requestServerCallBack != null) {
                        requestServerCallBack.Fail(response.code() + "", response.message(), "");
                    }
                }
            }
        });
    }

    public void post4Str() {

    }

    public void post4Json() {
        HttpUtils.getInstance().post4Json(url, jsonObject, MediaType.parse("application/json"), new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                if (requestServerCallBack != null) {
                    requestServerCallBack.Fail("0", e.getMessage(), "");
                }
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                if (response.code() == HTTP_OK) {
                    if (requestServerCallBack != null) {
                        try {
                            requestServerCallBack.Success(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if (requestServerCallBack != null) {
                        requestServerCallBack.Fail(response.code() + "", response.message(), "");
                    }
                }
            }
        });
    }
}
