package me.soomin.user.domain.dtd;

import lombok.Data;

import javax.validation.constraints.*;

//DTD
@Data
public class UserRegisterRequest {

    private Long userNo;

    private String userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private String userConfirmPassword;

    private boolean agreeCondition;

    public boolean matchConfirmPasswordToPassword(){
        return this.userPassword.equals(this.userConfirmPassword);
    }
}
