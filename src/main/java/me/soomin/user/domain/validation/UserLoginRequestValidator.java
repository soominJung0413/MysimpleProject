package me.soomin.user.domain.validation;

import me.soomin.user.domain.dtd.LoginRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserLoginRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LoginRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginRequest loginRequest = (LoginRequest)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"loginId","whiteSpace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"loginPassword","whiteSpace");

    }
}
