package com.stasroshchenko.diploma.util.annotation.constraint;

import com.stasroshchenko.diploma.util.annotation.validator.UniqueClientPassportIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueClientPassportIdValidator.class)
@Target( { ElementType.FIELD, ElementType.METHOD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueClientPassportIdConstraint {

    String message() default "This passport id has already been contained in our database. Please, ensure your input or contact our support";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}