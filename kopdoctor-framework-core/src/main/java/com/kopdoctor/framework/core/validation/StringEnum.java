package com.kopdoctor.framework.core.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringEnumValidator.class)
public @interface StringEnum {

    String[] enums();

    String message() default "String枚举超出范围值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
