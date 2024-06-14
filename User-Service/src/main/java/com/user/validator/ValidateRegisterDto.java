package com.user.validator;

import com.user.validator.handler.ValidateRegisterDtoHandler;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidateRegisterDtoHandler.class)
public @interface ValidateRegisterDto {
    String message() default "Invalid Request";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
