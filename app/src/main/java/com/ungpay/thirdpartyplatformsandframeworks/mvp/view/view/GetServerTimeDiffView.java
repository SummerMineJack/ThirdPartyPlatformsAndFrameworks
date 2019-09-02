package com.ungpay.thirdpartyplatformsandframeworks.mvp.view.view;

import com.ungpay.thirdpartyplatformsandframeworks.mvp.model.bean.GetServerTimeDiffBean;

public interface GetServerTimeDiffView {
    void setArticleInfo(GetServerTimeDiffBean articleInfo);

    void showLoading();

    void hideLoading();

    void showError();
}
