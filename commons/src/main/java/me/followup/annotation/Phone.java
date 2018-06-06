package me.followup.annotation;

import me.followup.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created on June 06, 2018
 * Created by: Badawy Abouads
 *
 * Mobile/Phone validation anotation
 *  Used Validator class PhoneValidator
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
    String message() default "Invalid Mobile/Phone Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
