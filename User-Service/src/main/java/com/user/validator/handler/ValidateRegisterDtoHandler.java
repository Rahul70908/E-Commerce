package com.user.validator.handler;

import com.user.dto.UserRegisterDto;
import com.user.validator.ValidateRegisterDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ValidateRegisterDtoHandler implements ConstraintValidator<ValidateRegisterDto, UserRegisterDto> {

    @Override
    public boolean isValid(UserRegisterDto userRegisterDto,
                           ConstraintValidatorContext context) {

        if (Objects.nonNull(userRegisterDto)) {
            if (StringUtils.isNotBlank(userRegisterDto.getEmail()) &&
                    StringUtils.isNotBlank(userRegisterDto.getPhone())) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Enter Either Email or Phone")
                        .addConstraintViolation();
                return false;
            }
            if (StringUtils.isNotBlank(userRegisterDto.getEmail()) &&
                    StringUtils.isBlank(userRegisterDto.getPhone())) {
                return true;
            }

            if (StringUtils.isNotBlank(userRegisterDto.getPhone()) &&
                    StringUtils.isBlank(userRegisterDto.getEmail())) {
                return true;
            }
        }
        return true;
    }
}
