package com.tatu.seckill.response;

import lombok.Data;

@Data
public class ErrorCodeMsg {
    private int code;
    private String msg;

    public static ErrorCodeMsg SERVER_ERROR = new ErrorCodeMsg(100500, "服务器错误");
    public static ErrorCodeMsg USER_NOT_FOUNT = new ErrorCodeMsg(100201, "用户不存在");

    private ErrorCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
