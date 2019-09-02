package com.ungpay.thirdpartyplatformsandframeworks.mvp.presenter;

import com.ungpay.thirdpartyplatformsandframeworks.mvp.model.bean.GetServerTimeDiffBean;

public interface OnGetServerTimeDiffListener {
    void onSuccess(GetServerTimeDiffBean getServerTimeDiffBean);
    void onStart();
    void onFailed();
    void onFinish();
}
