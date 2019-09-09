package com.tatu.seckill.vo;

import com.tatu.seckill.validator.NicknameValidation;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginVo {
    @NotNull
    @NicknameValidation
    private String nickname;

    @NotNull
    private String password;
}
