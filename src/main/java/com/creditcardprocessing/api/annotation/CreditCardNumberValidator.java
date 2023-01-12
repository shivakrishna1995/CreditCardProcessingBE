package com.creditcardprocessing.api.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CreditCardNumberValidator implements ConstraintValidator<ValidateCreditCardNumber, Long> {
    @Override
    public boolean isValid(Long ccNumber, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
