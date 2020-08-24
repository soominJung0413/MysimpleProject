package me.soomin.user.controller;

import lombok.extern.log4j.Log4j;
import me.soomin.user.domain.dtd.LoginRequest;
import me.soomin.user.domain.validation.UserLoginRequestValidator;
import me.soomin.user.domain.validation.UserRegisterRequestValidator;
import me.soomin.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@Component
@RequestMapping(value = {"/login"})
@Log4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String provideLoginForm(@ModelAttribute LoginRequest loginRequest, HttpServletRequest request,
                                   @CookieValue(value = "rememberId",required = false) Cookie cookie){
        log.info("로그인 폼 요청 받음 ::::"+loginRequest);
        if(!(cookie == null)){
            log.info(" 찾아낸 쿠키 값 :::::"+cookie.getValue());
            loginRequest.setLoginId(cookie.getValue());
        }

        return "user/login/form";
    }

    @PostMapping
    public String processLoginForm(@Valid @ModelAttribute LoginRequest loginRequest, Errors errors,
                                   HttpServletRequest request, HttpServletResponse response
            ,@CookieValue(value = "rememberId",required = false) Cookie cookie,
                                   RedirectAttributes redirectAttributes){
        log.info("로그인 폼 포스트 요청 받음 ::::"+loginRequest);
        log.info("세션 아이디 저장 동의여부 ::::"+loginRequest.isAgreeIdSave());

        loginService.login(loginRequest,errors,request,response,cookie);


        if(errors.hasErrors()){
            return "/user/login/form";
        }

        redirectAttributes.addFlashAttribute("Success","login"+loginRequest.getLoginId());

        return "redirect:/";
    }

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new UserLoginRequestValidator());
    }
}
