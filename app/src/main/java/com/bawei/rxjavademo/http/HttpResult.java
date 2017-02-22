package com.bawei.rxjavademo.http;

/**
 * Created by 姜鹏 on 2017/2/21.
 */

public class HttpResult<T> {
    public int error_code;
    public String reason;
    public T result;

    public int getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public T getResult() {
        return result;
    }

}
