package com.kopever.framework.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringEnumValidator.class)
public @interface StringEnum {

    String[] enums();

    String message() default "枚举字符超出范围值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
