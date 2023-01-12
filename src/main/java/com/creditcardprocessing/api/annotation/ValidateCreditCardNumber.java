package com.creditcardprocessing.api.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CreditCardNumberValidator.class)
public @interface ValidateCreditCardNumber {
    public String message() default "Invalid credit card number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
