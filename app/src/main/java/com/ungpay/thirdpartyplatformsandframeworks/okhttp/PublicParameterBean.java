package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Create by HuangJian on 2018/12/27
 * 每个接口须传入公共参数部分说明
 */
public class PublicParameterBean implements Parcelable {
    //app版本
    public String version;
    //时间差
    public String timeParam;
    //设备信息
    public String device;
    //时区
    public String timeZone;
    //平台Android ios
    public String platform;
    //请求数据，
    public String reqData;
    //签名
    public String sign;

    public PublicParameterBean() {

    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimeParam() {
        return timeParam;
    }

    public void setTimeParam(String timeParam) {
        this.timeParam = timeParam;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReqData() {
        return reqData;
    }

    public void setReqData(String reqData) {
        this.reqData = reqData;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    protected PublicParameterBean(Parcel in) {
        version = in.readString();
        timeParam = in.readString();
        device = in.readString();
        timeZone = in.readString();
        platform = in.readString();
        reqData = in.readString();
        sign = in.readString();
    }

    public static final Creator<PublicParameterBean> CREATOR = new Creator<PublicParameterBean>() {
        @Override
        public PublicParameterBean createFromParcel(Parcel in) {
            return new PublicParameterBean(in);
        }

        @Override
        public PublicParameterBean[] newArray(int size) {
            return new PublicParameterBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(version);
        dest.writeString(timeParam);
        dest.writeString(device);
        dest.writeString(timeZone);
        dest.writeString(platform);
        dest.writeString(reqData);
        dest.writeString(sign);
    }

}
