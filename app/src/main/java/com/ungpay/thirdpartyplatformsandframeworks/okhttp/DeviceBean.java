package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Create by HuangJian on 2018/12/27
 * 9.1设备信息
 */

public class DeviceBean implements Parcelable {
    //IMEI
    public String imei;
    //移动客户识别码
    public String imsi;
    //ICCID
    public String iccid;
    //MAC地址
    public List<String> macAddress;
    //移动设备网络代码
    public String mnc;
    //设备型号
    public String deviceName;
    //广告标志位
    public String idfa;
    //SEID
    public String seid;
    public String ip;

    public DeviceBean() {

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public List<String> getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(List<String> macAddress) {
        this.macAddress = macAddress;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getSeid() {
        return seid;
    }

    public void setSeid(String seid) {
        this.seid = seid;
    }

    protected DeviceBean(Parcel in) {
        imei = in.readString();
        ip = in.readString();
        imsi = in.readString();
        iccid = in.readString();
        macAddress = in.createStringArrayList();
        mnc = in.readString();
        deviceName = in.readString();
        idfa = in.readString();
        seid = in.readString();
    }

    public static final Creator<DeviceBean> CREATOR = new Creator<DeviceBean>() {
        @Override
        public DeviceBean createFromParcel(Parcel in) {
            return new DeviceBean(in);
        }

        @Override
        public DeviceBean[] newArray(int size) {
            return new DeviceBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imei);
        dest.writeString(imsi);
        dest.writeString(ip);
        dest.writeString(iccid);
        dest.writeStringList(macAddress);
        dest.writeString(mnc);
        dest.writeString(deviceName);
        dest.writeString(idfa);
        dest.writeString(seid);
    }
}
