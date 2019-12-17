package com.kopdoctor.framework.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringEnumValidator implements ConstraintValidator<StringEnum, String> {

    private Set<String> enums;

    @Override
    public void initialize(StringEnum constraintAnnotation) {
        String[] declaredEnums = constraintAnnotation.enums();
        enums = new HashSet<>(declaredEnums.length);
        Collections.addAll(enums, declaredEnums);
    }

    @Override
    public boolean isValid(String param, ConstraintValidatorContext constraintValidatorContext) {
        return param == null || enums.contains(param);
    }

}
