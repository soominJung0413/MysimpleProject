package me.soomin.user.service;

import me.soomin.user.domain.dtd.LoginRequest;
import org.springframework.validation.Errors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {

    public void login(LoginRequest loginRequest, Errors errors, HttpServletRequest request, HttpServletResponse response, Cookie cookie);
}
