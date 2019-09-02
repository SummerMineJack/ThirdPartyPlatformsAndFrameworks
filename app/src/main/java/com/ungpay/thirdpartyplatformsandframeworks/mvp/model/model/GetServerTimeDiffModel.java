package com.ungpay.thirdpartyplatformsandframeworks.mvp.model.model;

import com.ungpay.thirdpartyplatformsandframeworks.mvp.presenter.OnGetServerTimeDiffListener;

public interface GetServerTimeDiffModel {
    void getServerTimeDiff(OnGetServerTimeDiffListener onGetServerTimeDiffListener);
}
