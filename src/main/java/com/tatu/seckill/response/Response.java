package com.tatu.seckill.response;

import lombok.Data;

@Data
public class Response<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> Response<T> success(T data) {
        return new Response(0, "success", data);
    }

    public static <T> Response<T> error(ErrorCodeMsg errorCodeMsg) {
        Response response = new Response();
        response.code = errorCodeMsg.getCode();
        response.msg = errorCodeMsg.getMsg();
        return new Response(errorCodeMsg.getCode(), errorCodeMsg.getMsg());
    }

    private Response() {
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
