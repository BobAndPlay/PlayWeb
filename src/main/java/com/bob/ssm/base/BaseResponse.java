package com.bob.ssm.base;

/**
 * Created by Administrator on 2017/5/13.
 */
public class BaseResponse {
    String msg = "OK";
    String code = "1";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    String data;
}
