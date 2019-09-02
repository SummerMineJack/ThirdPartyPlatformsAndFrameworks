package com.ungpay.thirdpartyplatformsandframeworks.mvp.model.impl;

import com.ungpay.thirdpartyplatformsandframeworks.mvp.model.bean.GetServerTimeDiffBean;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.model.model.GetServerTimeDiffModel;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.presenter.OnGetServerTimeDiffListener;
import com.ungpay.thirdpartyplatformsandframeworks.okhttp.ServerInterfaceContant;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;
import okhttp3.Headers;

public class GetServerTimeDiffImpl implements GetServerTimeDiffModel {
    @Override
    public void getServerTimeDiff(final OnGetServerTimeDiffListener onGetServerTimeDiffListener) {
        RequestParams requestParams = new RequestParams();
        requestParams.addFormDataPart("clientTime", System.currentTimeMillis());
        HttpRequest.get(ServerInterfaceContant.appGetTimeDifference, requestParams, new BaseHttpRequestCallback<GetServerTimeDiffBean>() {
            @Override
            public void onStart() {
                super.onStart();
                onGetServerTimeDiffListener.onStart();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                onGetServerTimeDiffListener.onFinish();
            }

            @Override
            protected void onSuccess(Headers headers, GetServerTimeDiffBean getServerTimeDiffBean) {
                super.onSuccess(headers, getServerTimeDiffBean);
                onGetServerTimeDiffListener.onSuccess(getServerTimeDiffBean);
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                onGetServerTimeDiffListener.onFailed();
            }
        });
    }
}
