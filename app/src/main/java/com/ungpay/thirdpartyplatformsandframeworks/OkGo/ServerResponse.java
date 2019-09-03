package com.ungpay.thirdpartyplatformsandframeworks.OkGo;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
    public String resultcode;
    public String reason;
    public T result;
    public int error_code;

}
