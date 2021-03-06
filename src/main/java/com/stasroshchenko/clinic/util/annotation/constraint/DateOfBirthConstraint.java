package com.stasroshchenko.clinic.util.annotation.constraint;

import com.stasroshchenko.clinic.util.annotation.validator.DateOfBirthValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Validates an user's date of birth format.
 * @author staffsterr2000
 * @version 1.0
 */
@Documented
@Constraint(validatedBy = DateOfBirthValidation.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOfBirthConstraint {

    String message() default "Date is invalid. Try picking up a more realistic one.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
