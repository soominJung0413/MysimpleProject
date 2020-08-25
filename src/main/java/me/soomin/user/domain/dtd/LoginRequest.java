package me.soomin.user.domain.dtd;
//DTD

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class LoginRequest {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{5,12}")
    private String loginId;
    @NotBlank
    @Size(min = 4)
    private String loginPassword;
    private boolean agreeIdSave;
}
