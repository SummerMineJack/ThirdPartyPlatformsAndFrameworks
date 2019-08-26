package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

/**
 * Create by HuangJian on 2019/1/2
 * 请求服务端接口返回操作
 */
public interface RequestServerCallBack {
    void Fail(String responseCode, String responseMessage, String responseData);

    void Success(String successData);
}
