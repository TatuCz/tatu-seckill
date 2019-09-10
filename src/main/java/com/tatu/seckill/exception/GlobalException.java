package com.tatu.seckill.exception;

import com.tatu.seckill.response.ErrorCodeMsg;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    private ErrorCodeMsg errorCodeMsg;

    public GlobalException(ErrorCodeMsg errorCodeMsg) {
        this.errorCodeMsg = errorCodeMsg;
    }
}
