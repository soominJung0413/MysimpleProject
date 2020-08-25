package me.soomin.user.controller;

import lombok.extern.log4j.Log4j;
import me.soomin.user.domain.dtd.UserModifyRequest;
import me.soomin.user.domain.dtd.UserRegisterRequest;
import me.soomin.user.domain.dtd.UserRemoveRequest;
import me.soomin.user.domain.validation.UserRegisterRequestValidator;
import me.soomin.user.domain.vo.UserInfoVO;
import me.soomin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/user")
@Log4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/create")
    public String provideRegisterForm(@ModelAttribute UserRegisterRequest userRegisterRequest){
        log.info("유저 서비스 Get 요청 커멘드 객체는 빈 상태 여야함 :::::\n"+userRegisterRequest);
        return "user/create/form";
    }

    @PostMapping(value = "/create")
    public String registerUser(@Valid @ModelAttribute UserRegisterRequest userRegisterRequest, Errors errors, RedirectAttributes redirectAttributes){
        log.info("요청된 유저 정보 ::::::::::::::::::::::"+userRegisterRequest);
        log.info("작성된 폼에대한 에러 확인 :::::::\n"+errors.getAllErrors());
//        log.info(" 파라메터 정보 ::"+ Arrays.toString(request.getParameterMap().keySet().toArray()));


        UserInfoVO userInfoVO = userService.readUserId(userRegisterRequest.getUserId());
        log.info(userInfoVO);
        if(userInfoVO != null) {
            if (userInfoVO.getUserId().equals(userRegisterRequest.getUserId())) {
                errors.reject("existsAccount");
            }
        }

        if(errors.hasErrors()){
            return "user/create/form";
        }

        Long registerUserNo = userService.registerUserInfoGetKey(userRegisterRequest);

        redirectAttributes.addFlashAttribute("Success","register"+registerUserNo);

        return "redirect:/";
    }

    @GetMapping(value = "/modify")
    public void provideModifyForm(@ModelAttribute UserModifyRequest userModifyRequest){
        log.info("유저 정보 수정 서비스 GET 커맨드 객체 상태 ::::::\n"+ userModifyRequest);

    }

    @PostMapping(value = "/modify")
    public String modifyUserInfo(@ModelAttribute UserModifyRequest userModifyRequest , Errors errors){
        log.info("유저정보 수정 POST 커맨드 객체 상태 :::::\n"+userModifyRequest);

        return "redirect:/main";
    }

    @GetMapping(value = "/delete/{userNo}")
    public String provideRemoveForm(@PathVariable("userNo") Long userNo, HttpServletRequest httpServletRequest,
                                  @ModelAttribute UserRemoveRequest userRemoveRequest){
        HttpSession httpSession = httpServletRequest.getSession(false);
//        Long userNo = (Long)httpSession.getAttribute("userInfo");

        log.info("유저정보 삭제 GET 세션에서 넘어온 유저번호 :::::: "+userNo);
        return "user/delete/form.jsp";
    }

    @PostMapping(value = "/delete/{userNo}")
    public String removeUserInfo(@PathVariable("userNo") Long userNo,@ModelAttribute UserRemoveRequest userRemoveRequest, Errors errors){
        log.info("유저정보 삭제 POST 넘어온 유저 번호 :::::: "+userNo);
        log.info("유저정보 삭제 POST 넘어온 커맨드 객체 ::::::::::\n"+userRemoveRequest);

        boolean result = userService.removeUserInfo(userNo);

        log.info("정보 삭제 여부 :::::::::"+result);


        return "redirect:/main";
    }



    @InitBinder
    protected void InitBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(new UserRegisterRequestValidator());
    }
}
