package com.bob.ssm.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Object data;
}
