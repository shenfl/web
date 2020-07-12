package com.test.cloud.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author shenfl
 */
@Documented
@Constraint(validatedBy = StatusValidationValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RUNTIME)
public @interface StatusValidation {
    Class<? extends Enum<?>> enumClass();
    String message() default "错误啦"; // 必须包含message属性，不然spring报错
    Class<?>[] groups() default {}; // 必须包含groups属性，不然spring报错
    Class<? extends Payload>[] payload() default {}; // 必须包含groups属性，不然spring报错
}
