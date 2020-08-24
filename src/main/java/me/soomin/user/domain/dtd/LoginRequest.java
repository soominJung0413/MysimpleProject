package me.soomin.user.domain.dtd;
//DTD

import lombok.Data;

@Data
public class LoginRequest {

    private String loginId;
    private String loginPassword;
    private boolean agreeIdSave;
}
