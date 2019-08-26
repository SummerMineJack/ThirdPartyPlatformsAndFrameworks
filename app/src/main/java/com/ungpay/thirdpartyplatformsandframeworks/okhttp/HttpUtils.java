package com.ungpay.thirdpartyplatformsandframeworks.okhttp;

import org.json.JSONObject;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtils {
    private final static int CONNECT_TIMEOUT = 60;
    private final static int READ_TIMEOUT = 100;
    private final static int WRITE_TIMEOUT = 60;
    private static OkHttpClient okHttpClient = null;
    private static HttpUtils httpUtils = null;

    public static synchronized HttpUtils getInstance() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    private HttpUtils() {
        okHttpClient = getOkHttpClient();
    }

    private static synchronized OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .sslSocketFactory(createSSLSocketFactory(), new SafeTrustManager())
                    .hostnameVerifier(new TrustAllHostnameVerifier())
                    .retryOnConnectionFailure(false)
                    .build();
        }
        return okHttpClient;
    }

    public void get(String url, Callback callback) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public void post4Str(String url, Callback callback, FormBody.Builder builder) {
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    public void post4Json(String url, JSONObject jsonObject, MediaType mediaType, Callback callback) {
        RequestBody requestBody = RequestBody.create(String.valueOf(jsonObject), mediaType);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    private static class SafeTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    //信任所有的服务器,返回true
    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory sslSocketFactory = null;
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{new SafeTrustManager()}, new SecureRandom());
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return sslSocketFactory;
    }
}
