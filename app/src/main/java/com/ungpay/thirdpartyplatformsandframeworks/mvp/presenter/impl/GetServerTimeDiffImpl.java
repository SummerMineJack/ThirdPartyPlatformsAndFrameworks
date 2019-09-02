package com.ungpay.thirdpartyplatformsandframeworks.mvp.presenter.impl;

import com.ungpay.thirdpartyplatformsandframeworks.mvp.model.bean.GetServerTimeDiffBean;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.model.model.GetServerTimeDiffModel;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.presenter.OnGetServerTimeDiffListener;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.presenter.ServerTimeDiffPresenter;
import com.ungpay.thirdpartyplatformsandframeworks.mvp.view.view.GetServerTimeDiffView;

public class GetServerTimeDiffImpl implements ServerTimeDiffPresenter, OnGetServerTimeDiffListener {
    private GetServerTimeDiffView getServerTimeDiffView;
    private GetServerTimeDiffModel getServerTimeDiffModel;

    public GetServerTimeDiffImpl(GetServerTimeDiffView getServerTimeDiffView) {
        this.getServerTimeDiffView = getServerTimeDiffView;
        getServerTimeDiffModel = new com.ungpay.thirdpartyplatformsandframeworks.mvp.model.impl.GetServerTimeDiffImpl();
    }

    @Override
    public void onSuccess(GetServerTimeDiffBean getServerTimeDiffBean) {
        getServerTimeDiffView.setArticleInfo(getServerTimeDiffBean);
    }

    @Override
    public void onStart() {
        getServerTimeDiffView.showLoading();
    }

    @Override
    public void onFailed() {
        getServerTimeDiffView.showError();
    }

    @Override
    public void onFinish() {
        getServerTimeDiffView.hideLoading();
    }

    @Override
    public void getServerTimeDiff() {
        getServerTimeDiffModel.getServerTimeDiff(this);
    }
}
