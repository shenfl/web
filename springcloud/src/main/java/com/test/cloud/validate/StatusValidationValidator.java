package com.test.cloud.validate;

import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shenfl
 */
public class StatusValidationValidator implements ConstraintValidator<StatusValidation, String> {
    private Set<String> set = new HashSet<>();
    @Override
    public void initialize(StatusValidation constraintAnnotation) {
        Class<? extends Enum<?>> aClass = constraintAnnotation.enumClass();
        Enum<?>[] enumConstants = aClass.getEnumConstants();
        for (Enum<?> enumConstant : enumConstants) {
           set.add(enumConstant.toString());
        }
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) return true;
        return set.contains(s);
    }
}
