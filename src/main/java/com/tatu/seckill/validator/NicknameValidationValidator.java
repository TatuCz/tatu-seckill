package com.tatu.seckill.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NicknameValidationValidator implements ConstraintValidator<NicknameValidation, String> {

    @Override
    public void initialize(NicknameValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return false;
        } else if (s.length() > 6) {
            return true;
        }
        return false;
    }
}
