package com.kopdoctor.framework.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntEnumValidator implements ConstraintValidator<IntEnum, Integer> {

    private Set<Integer> enums;

    @Override
    public void initialize(IntEnum constraintAnnotation) {
        int[] declaredEnums = constraintAnnotation.enums();
        enums = new HashSet<>(declaredEnums.length);
        Arrays.stream(declaredEnums).forEach(enums::add);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || enums.contains(value);
    }

}
