package com.tatu.seckill.response;

import lombok.Data;

@Data
public class ErrorCodeMsg {
    private int code;
    private String msg;

    public static ErrorCodeMsg SERVER_ERROR = new ErrorCodeMsg(100100, "服务器错误");
    public static ErrorCodeMsg BIND_EXCEPTION = new ErrorCodeMsg(100101, "参数校验异常. %s");


    public static ErrorCodeMsg USER_NOT_FOUNT = new ErrorCodeMsg(100201, "用户不存在");

    public static ErrorCodeMsg NICKNAME_EMPTY = new ErrorCodeMsg(100300, "登陆用户名不能为空");
    public static ErrorCodeMsg PASSWORD_EMPTY = new ErrorCodeMsg(100301, "登陆密码不能为空");
    public static ErrorCodeMsg PASSWORD_NOT_MATCH = new ErrorCodeMsg(100303, "密码错误");

    private ErrorCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ErrorCodeMsg fillArgs(Object... args) {
        this.msg = String.format(this.msg, args);
        return this;
    }
}
