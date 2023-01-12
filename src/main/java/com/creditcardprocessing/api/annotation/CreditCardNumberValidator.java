package com.creditcardprocessing.api.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CreditCardNumberValidator implements ConstraintValidator<ValidateCreditCardNumber, String> {
    @Override
    public boolean isValid(String ccNumber, ConstraintValidatorContext constraintValidatorContext) {
        int[] ccInt = new int[ccNumber.length()];
        int total = 0;
        for (int i = 0; i < ccNumber.length(); i++){
            ccInt[i] = Integer.parseInt(ccNumber.substring(i, i+1));
        }
        for (int i =ccInt.length - 2; i >= 0; i = i - 2){
            int tempValue = ccInt[i];
            tempValue = tempValue * 2;
            if(tempValue > 9) {
                tempValue = tempValue % 10 + 1;
            }
            ccInt[i] = tempValue;
        }
        for (int i = 0; i < ccInt.length; i++){
            total += ccInt[i];
        }
        if(total % 10 == 0){
            return true;
        }
        return false;
    }
}
