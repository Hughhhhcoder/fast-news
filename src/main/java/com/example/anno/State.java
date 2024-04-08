package com.example.anno;

import com.example.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented//元注解
@Constraint(
        validatedBy = {StateValidation.class}//指定提供校验规则的类
)
@Target({ ElementType.FIELD})//元注解
@Retention(RetentionPolicy.RUNTIME)
public @interface State {


    String message() default "state参数的值只能是已发布或者是草稿";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
