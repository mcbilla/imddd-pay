package com.mcb.imddd.pay.infrastructure.common;

public class ResultCode {

    private String code;

    private String msg;

    public static final ResultCode SUCCESS = new ResultCode("0", "ok");

    public static final ResultCode INTERNAL_SERVER_ERROR = new ResultCode("500", "server error");

    public static final ResultCode UNAUTHENTICATED = new ResultCode("401", "unauthenticated");

    public ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
