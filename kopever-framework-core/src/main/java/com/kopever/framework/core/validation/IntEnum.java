package com.kopever.framework.core.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntEnumValidator.class)
public @interface IntEnum {

    int[] enums();

    String message() default "枚举数字超出范围值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
