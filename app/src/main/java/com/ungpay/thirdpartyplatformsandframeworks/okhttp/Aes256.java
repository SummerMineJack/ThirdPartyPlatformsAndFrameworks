package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

import com.blankj.utilcode.util.LogUtils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * java实现AES256加密解密
 * 依赖说明：
 * bcprov-jdk15-133.jar：PKCS7Padding
 * javabase64-1.3.1.jar：base64
 * local_policy.jar 和 US_export_policy.jar需添加到%JAVE_HOME%\jre\lib\security中（lib中版本适合jdk1.7）
 * 加密说明：
 * 加密算法为AES256，工作模式为ECB，填充模式PKCS7Padding，加密后得到的字节数组转换成16进制字符串返回。
 * 加密的内容通过getBytes("utf-8")转换成字节数组。
 * Appid先 通过getBytes("utf-8")转换成字节数组，然后通过sha256得到最终的密钥。密钥为32个字节。
 */

public class Aes256 {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static byte[] encrypt(String content, String password) {
        try {
            //返回基本编码格式的密钥  
            byte[] enCodeFormat = tohash256Deal(password);
            //根据给定的字节数组构造一个密钥。enCodeFormat：密钥内容；"AES"：与给定的密钥内容相关联的密钥算法的名称
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            //将提供程序添加到下一个可用位置   
            //创建一个实现指定转换的 Cipher对象，该转换由指定的提供程序提供。  
            //"AES/ECB/PKCS7Padding"：转换的名称；"BC"：提供程序的名称  
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes("utf-8");
            byte[] cryptograph = cipher.doFinal(byteContent);
            return cryptograph;
        } catch (Exception e) {
            LogUtils.e(e);
        }
        return null;
    }

    public static String decrypt(byte[] cryptograph, String password) {
        try {
            byte[] enCodeFormat = tohash256Deal(password);
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] content = cipher.doFinal(cryptograph);
            return new String(content, "utf-8");
        } catch (Exception e) {
            LogUtils.e(e);
        }
        return null;
    }

    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static byte[] tohash256Deal(String datastr) {
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            digester.update(datastr.getBytes("UTF-8"));
            byte[] hex = digester.digest();
            return hex;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}  