package com.kopdoctor.framework.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = IntEnumValidator.class)
public @interface IntEnum {

    int[] enums();

    String message() default "Int枚举超出范围值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
