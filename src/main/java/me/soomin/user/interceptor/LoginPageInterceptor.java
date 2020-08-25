package me.soomin.user.interceptor;

import lombok.extern.log4j.Log4j;
import me.soomin.user.domain.vo.UserInfoVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j
public class LoginPageInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        UserInfoVO userInfoVO = (UserInfoVO)httpSession.getAttribute("userInfo");

        log.info("인터셉터 작동 ::: 세션정보 "+userInfoVO);

        if(userInfoVO == null){
            return true;
        }

        response.sendRedirect(request.getContextPath()+"/");
        return false;
    }
}