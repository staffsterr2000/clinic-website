package com.stasroshchenko.diploma.util.annotation.validator;

import com.stasroshchenko.diploma.util.annotation.constraint.UsernameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UsernameValidator
        implements ConstraintValidator<UsernameConstraint, String> {

    @Override
    public void initialize(UsernameConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.matches("[A-Za-z0-9_]+", username);
    }

}