package com.ungpay.thirdpartyplatformsandframeworks.OkGo;

import com.lzy.okgo.callback.AbsCallback;

import okhttp3.Response;

public abstract class CustomJsonCallback<T> extends AbsCallback<T> {

    @Override
    public T convertResponse(Response response) {
        return null;
    }
}
