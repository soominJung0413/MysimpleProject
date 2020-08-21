package me.soomin.user.service;

import me.soomin.user.domain.dtd.UserModifyRequest;
import me.soomin.user.domain.dtd.UserRegisterRequest;
import me.soomin.user.domain.vo.UserInfoVO;
import me.soomin.user.persistence.mapper.SimpleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService{

    @Autowired
    private SimpleMapper simpleMapper;

    @Override
    public String getNowTime() {
        return simpleMapper.getNow();
    }

    @Override
    public UserInfoVO readUserInfo(Long userNo) {
        return simpleMapper.get(userNo);
    }

    @Override
    public UserInfoVO readUserId(String userId) {
        return simpleMapper.getFromId(userId);
    }


    @Override
    public List<UserInfoVO> getUserInfoList() {
        return simpleMapper.getList();
    }

    @Override
    public boolean registerUserInfo(UserRegisterRequest userRegisterRequest) {
        int inserCount = simpleMapper.insert(userRegisterRequest);

        return inserCount == 1;
    }

    @Override
    public Long registerUserInfoGetKey(UserRegisterRequest userRegisterRequest){
        Long registerCount = simpleMapper.insertSelectKey(userRegisterRequest);

        if(registerCount == 1L){
            return userRegisterRequest.getUserNo();
        }

        return -1L;
    }

    @Override
    public boolean modifyUserInfo(UserModifyRequest userModifyRequest) {
        int modifyCount = simpleMapper.update(userModifyRequest);

        return modifyCount == 1;
    }

    @Override
    public boolean removeUserInfo(Long userNo) {
        int deleteCount = simpleMapper.delete(userNo);

        return deleteCount == 1;
    }
}
