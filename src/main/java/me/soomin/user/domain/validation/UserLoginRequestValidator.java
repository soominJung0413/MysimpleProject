package me.soomin.user.domain.validation;

import me.soomin.user.domain.dtd.LoginRequest;
import me.soomin.user.domain.vo.UserInfoVO;
import me.soomin.user.persistence.mapper.SimpleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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


        }
    }

