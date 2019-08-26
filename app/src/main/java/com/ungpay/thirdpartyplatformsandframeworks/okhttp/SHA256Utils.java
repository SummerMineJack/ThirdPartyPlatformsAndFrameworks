package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

import java.security.MessageDigest;

public class SHA256Utils {


    private SHA256Utils() {
    }

    public static String encrypt(String text) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(text.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (Exception e) {
        }
        return encodeStr;
    }

    private static String byte2Hex(byte[] digest) {
        StringBuilder stringBuffer = new StringBuilder();
        String temp = null;
        for (int i = 0; i < digest.length; i++) {
            temp = Integer.toHexString(digest[i] & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}
