package com.tatu.seckill.exception;

import com.tatu.seckill.response.ErrorCodeMsg;
import com.tatu.seckill.response.Response;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 19-9-10.
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Response<String> handleException(HttpServletRequest request, Exception e) {
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            return Response.error(ErrorCodeMsg.BIND_EXCEPTION.fillArgs(bindException.getMessage()));
        } else if (e instanceof GlobalException){
            GlobalException globalException = (GlobalException) e;
            ErrorCodeMsg errorCodeMsg = globalException.getErrorCodeMsg();
            return Response.error(errorCodeMsg);
        } else {
            return Response.error(ErrorCodeMsg.SERVER_ERROR);
        }
    }
}
