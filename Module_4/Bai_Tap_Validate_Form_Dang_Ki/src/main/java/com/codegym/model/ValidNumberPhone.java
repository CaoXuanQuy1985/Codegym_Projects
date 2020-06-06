package com.codegym.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberPhoneValidator.class)
@Documented
public @interface ValidNumberPhone {
    String message() default "Invalid NumberPhone";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
