package me.soomin.user.domain.dtd;

import lombok.Data;

//DTD
@Data
public class UserRemoveRequest {
    private String userId;
    private String userName;
    private String userPassword;
    private String userConfirmPassword;


    public boolean ConfirmPasswordMatchToPassword(){
        return this.userConfirmPassword.equals(this.userPassword);
    }
}
