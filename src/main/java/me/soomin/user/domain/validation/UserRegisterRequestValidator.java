package me.soomin.user.domain.validation;

import lombok.extern.log4j.Log4j;
import me.soomin.user.domain.dtd.UserRegisterRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Log4j
public class UserRegisterRequestValidator implements Validator {

    //
    private final String emailRegex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //시작은 영문으로만, '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하
    private final String idRegex="^[a-zA-Z0-9._%+-]{5,12}";

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegisterRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userId","whiteSpace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","whiteSpace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userPassword","whiteSpace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userConfirmPassword","whiteSpace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userEmail","whiteSpace");

        UserRegisterRequest userRegisterRequest =(UserRegisterRequest)target;

        Pattern idPattern = Pattern.compile(idRegex);
        Matcher idMatcher = idPattern.matcher(userRegisterRequest.getUserId());

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher1 = emailPattern.matcher(userRegisterRequest.getUserEmail());


        if(!(emailMatcher1.matches())){
            errors.rejectValue("userEmail","notMatch");
        }
        if(!(idMatcher.matches())){
            errors.rejectValue("userId","notMatch");
        }


       if(!userRegisterRequest.matchConfirmPasswordToPassword()){
           errors.rejectValue("userConfirmPassword","notMatching");
       }
       if(!userRegisterRequest.isAgreeCondition()){
           errors.rejectValue("agreeCondition","notChecking");
       }
    }
}
