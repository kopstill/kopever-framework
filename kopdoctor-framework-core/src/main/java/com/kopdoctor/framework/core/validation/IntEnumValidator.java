package com.kopdoctor.framework.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

public class IntEnumValidator implements ConstraintValidator<IntEnum, Integer> {

    private Set<Integer> enums;

    @Override
    public void initialize(IntEnum constraintAnnotation) {
        this.enums = new HashSet<>();
        int[] params = constraintAnnotation.enums();
        for (int param : params) {
            this.enums.add(params[param]);
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return enums == null || this.enums.contains(value);
    }

}
