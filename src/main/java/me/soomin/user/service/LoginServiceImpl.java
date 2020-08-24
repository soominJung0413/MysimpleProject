package me.soomin.user.service;


import lombok.extern.log4j.Log4j;
import me.soomin.user.domain.dtd.LoginRequest;
import me.soomin.user.domain.vo.UserInfoVO;
import me.soomin.user.persistence.mapper.SimpleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Service
@Log4j
public class LoginServiceImpl implements  LoginService{

    @Autowired
    private SimpleMapper simpleMapper;
    @Override
    public void login(LoginRequest loginRequest, Errors errors, HttpServletRequest request, HttpServletResponse response,Cookie cookie) {
        UserInfoVO userInfoVO = simpleMapper.getFromId(loginRequest.getLoginId());
        if(userInfoVO == null){
            errors.reject("NotExistsMember");
        }else{
            if(!(userInfoVO.getUserPassword().equals(loginRequest.getLoginPassword()))){
                errors.rejectValue("loginPassword","notMatching");
            }
        }


        if(errors.hasErrors()){
            return;
        }

        if(cookie == null){
            cookie = new Cookie("rememberId",loginRequest.getLoginId());
        }

        log.info("아이디 동의 체크 여부 ::::"+loginRequest.isAgreeIdSave());
        if(loginRequest.isAgreeIdSave()){
            cookie.setMaxAge(60*60*24*30);
            cookie.setPath("/login");
            log.info("쿠키 정보 ::::"+cookie.getMaxAge()+" , "+cookie.getPath()+" , "+cookie.getValue() + " , "+cookie.getName());
            response.addCookie(cookie);
        }else{
            cookie.setMaxAge(-1);
            log.info("쿠키 정보 ::::"+cookie.getMaxAge()+" , "+cookie.getPath()+" , "+cookie.getValue() + " , "+cookie.getName());
            response.addCookie(cookie);
        }

        log.info("세션에 저장할 유저정보 ::::"+userInfoVO);

        HttpSession httpSession = request.getSession(false);
        httpSession.setAttribute("userInfo",userInfoVO);
    }
}
