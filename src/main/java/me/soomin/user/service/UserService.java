package me.soomin.user.service;

import me.soomin.user.domain.dtd.UserModifyRequest;
import me.soomin.user.domain.dtd.UserRegisterRequest;
import me.soomin.user.domain.vo.UserInfoVO;

import java.util.List;


public interface UserService {

    public String getNowTime();

    public UserInfoVO readUserInfo(Long userNo);

    public UserInfoVO readUserId(String userId);

    public List<UserInfoVO> getUserInfoList();

    public boolean registerUserInfo(UserRegisterRequest userRegisterRequest);

    public Long registerUserInfoGetKey(UserRegisterRequest userRegisterRequest);

    public boolean modifyUserInfo(UserModifyRequest userModifyRequest);

    public boolean removeUserInfo(Long userNo);
}
