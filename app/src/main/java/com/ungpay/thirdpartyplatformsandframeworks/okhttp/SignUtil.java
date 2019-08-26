package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ungpay.thirdpartyplatformsandframeworks.BuildConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

/**
 * Create by HuangJian on 2018/12/27
 * 签名公共参数及接口参数
 */
public class SignUtil {
    private static final String randImeiprefix = "16738";

    /**
     * 根据hashmap 的value值获取key
     *
     * @param map
     * @param value
     * @return
     */
    public static String getKey(HashMap<String, String> map, String value) {
        String key = null;
        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        for (String getKey : map.keySet()) {
            if (map.get(getKey).equals(value)) {
                key = getKey;
            }
        }
        return key;
        //这个key肯定是最后一个满足该条件的key.
    }

    /**
     * 金额保留小数
     *
     * @param money
     * @return
     */
    public static String long2StringFormat(long money) {
        String moneyFormat = new DecimalFormat(".00").format(money / 100d);
        BigDecimal bigDecimal = new BigDecimal(moneyFormat);
        return bigDecimal.toString();
    }

    /**
     * [手机号码] 国内号码:前三位，后四位，其他隐藏<例子:138****1234>
     * 国外号码:前两位,后两位,其他隐藏<例子:18****89>
     *
     * @return
     */
    public static String mobilePhone(String mobile) {
        // 国内11位手机号码
        if (mobile.length() == 11) {
            return mobile.replace(mobile.substring(3, 7), "****");
        }
        // 国外手机号码
        if (mobile.length() > 0 && mobile.length() < 11) {
            String firstTwo = mobile.substring(0, 2);
            String lastTwo = mobile.substring(mobile.length() - 2);
            return firstTwo + getHideStar(mobile.length() - 4) + lastTwo;
        }
        return "";
    }

    /**
     * [电子邮箱] 对email地址中@前的字符进行隐藏，隐藏的位数为@前总字符数的1/2（奇数的隐藏位数+1），保留字符在前隐藏字符在后。
     * 偶数：ab**@ungpay.com
     * 奇数：ab***@ungpay.com
     * 2个字符：a*@ungpay.com
     * 1个字符：*@ungpay.com
     *
     * @param email
     * @return
     */
    public static String email(String email) {
        if (TextUtils.isEmpty(email)) {
            return "";
        }
        String first = email.split("@")[0];
        String last = "@" + email.split("@")[1];
        if (1 == first.length()) {
            return "*" + last;
        }
        if (2 == first.length()) {
            return first.substring(0, 1) + "*" + last;
        }
        int hideBit = 0;
        if (first.length() % 2 == 0) {
            hideBit = first.length() / 2;
            return first.substring(0, hideBit) + getHideStar(hideBit) + last;
        } else {
            hideBit = first.length() / 2 + 1;
            return first.substring(0, hideBit - 1) + getHideStar(hideBit) + last;
        }
    }

    /**
     * 获取隐藏的*
     * <p>Description: </p>
     *
     * @param hideBit
     * @return
     */
    private static String getHideStar(int hideBit) {
        StringBuilder hideStar = new StringBuilder();
        for (int i = 0; i < hideBit; i++) {
            hideStar.append("*");
        }
        return hideStar.toString();
    }

    /**
     * @param context
     * @return
     */
    @SuppressLint("MissingPermission")
    private static DeviceBean setDeviceBean(Context context) {
        TelephonyManager telephonyManager =
                (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        List<String> mac = new ArrayList<>();
        mac.add(DeviceUtils.getMacAddress());
        DeviceBean deviceBean = new DeviceBean();
        deviceBean.setImei(getImei());
        deviceBean.setImsi(PhoneUtils.getIMSI());
        deviceBean.setIccid(telephonyManager.getSimSerialNumber());
        deviceBean.setMacAddress(mac);
        deviceBean.setDeviceName(DeviceUtils.getModel());
        return deviceBean;
    }

    @SuppressLint("MissingPermission")
    private static String getImei() {
        String imei = SPUtils.getInstance("imeikey").getString("imeikey", "");
        if (TextUtils.isEmpty(imei)) {
            imei = PhoneUtils.getIMEI();
            if (TextUtils.isEmpty(imei) || "000000000000000".equals(imei)) {
                Random random = new Random();
                imei = randImeiprefix + (1000000000 + random.nextInt(899999999));
                SPUtils.getInstance("imeikey").put("imeikey", imei);
            } else {
                SPUtils.getInstance("imeikey").put("imeikey", imei);
            }
        }

        return imei;
    }

    /**
     * @param requestData 传参【jsonString】
     * @param context     上下文
     * @param diffTine    本地时间与服务器时间的差值
     * @return
     */
    public static PublicParameterBean setPublicParames(String requestData, Context context,
                                                       long diffTine, String randomStr,
                                                       long localTime) {
        PublicParameterBean publicParameterBean = new PublicParameterBean();
        publicParameterBean.setVersion(BuildConfig.VERSION_NAME);
        publicParameterBean.setTimeParam((String.valueOf((Long.valueOf(localTime) + diffTine)) + randomStr));
        publicParameterBean.setDevice(new Gson().toJson(setDeviceBean(context)));
        publicParameterBean.setTimeZone(TimeZone.getDefault().getDisplayName(false,
                TimeZone.SHORT).replace("GMT", ""));
        publicParameterBean.setPlatform("Android");
        publicParameterBean.setReqData(requestData);
        publicParameterBean.setSign(sign(publicParameterBean, diffTine, String.valueOf(localTime)
                , randomStr));
        return publicParameterBean;
    }


    /**
     * 将所有的公共参数与请求私有参数进行加密
     *
     * @return
     */
    private static String sign(PublicParameterBean publicParameterBean, long diffTime,
                               String localTime, String randomStr) {
        return SHA256Utils.encrypt(createToken(diffTime, localTime, randomStr) + new GsonBuilder().disableHtmlEscaping().create().toJson(publicParameterBean));
    }

    /**
     * 生成token
     * Appkey需要与服务端进行规定
     *
     * @return
     */
    public static String createToken(long diffTime, String localTime, String randomStr) {
        return SHA256Utils.encrypt((String.valueOf((Long.valueOf(localTime) + diffTime)) + randomStr) + "appKey123456");
    }

    public static JSONObject jsonParames(PublicParameterBean publicParameterBean) throws JSONException {
        JSONObject publicjsonObject = new JSONObject();
        publicjsonObject.put("version", publicParameterBean.getVersion());
        publicjsonObject.put("timeParam", publicParameterBean.getTimeParam());
        publicjsonObject.put("device", publicParameterBean.getDevice());
        publicjsonObject.put("timeZone", publicParameterBean.getTimeZone());
        publicjsonObject.put("platform", publicParameterBean.getPlatform());
        publicjsonObject.put("reqData", publicParameterBean.getReqData());
        publicjsonObject.put("sign", publicParameterBean.getSign());
        return publicjsonObject;
    }
}
