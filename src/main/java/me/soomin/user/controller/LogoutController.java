package me.soomin.user.controller;

import lombok.extern.log4j.Log4j;
import me.soomin.user.domain.vo.UserInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Log4j
public class LogoutController {

    @GetMapping(value = "/{userId}/logout")
    public String processLogout(@PathVariable(name = "userId",required = true) String userId, HttpSession httpSession, RedirectAttributes redirectAttributes){
        UserInfoVO userInfoVO = (UserInfoVO) httpSession.getAttribute("userInfo");
        if(userInfoVO.getUserId().equals(userId)){
            httpSession.invalidate();
            redirectAttributes.addFlashAttribute("Success","logout"+userId);
            return "redirect:/";
        }else{
            httpSession.invalidate();
            redirectAttributes.addFlashAttribute("Success","Failed"+userInfoVO.getUserId());
            return "redirect:/";
        }
    }
}
