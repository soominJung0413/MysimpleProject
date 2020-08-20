package me.soomin.user.domain.dtd;

import lombok.Data;

//DTD
@Data
public class UserRegisterRequest {
    private Long userNo;
    private String userId;
    private String userName;
    private String userPassword;
    private String userConfirmPassword;

    public boolean matchConfirmPasswordToPassword(){
        return this.userPassword.equals(this.userConfirmPassword);
    }
}
