package me.soomin.user.domain.vo;


import lombok.Data;

import java.util.Date;

@Data
public class UserInfoVO {

    private Long userNo;

    private String userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private Date regdate;

    private Date updateDate;

}
