package me.soomin.user.domain.dtd;

import lombok.Data;

import javax.validation.constraints.*;

//DTD
@Data
public class UserRegisterRequest {

    private Long userNo;

    @Pattern(regexp = "^[a-zA-Z0-9]{5,12}$")
    @NotBlank
    private String userId;
    @Size(min = 3)
    @NotBlank
    private String userName;
    @Email
    @NotBlank
    private String userEmail;
    @Size(min = 4)
    @NotBlank
    private String userPassword;
    @Size(min = 4)
    @NotBlank
    private String userConfirmPassword;
    @AssertTrue
    private boolean agreeCondition;

    public boolean matchConfirmPasswordToPassword(){
        return this.userPassword.equals(this.userConfirmPassword);
    }
}
