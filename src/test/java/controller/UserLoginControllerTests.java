package controller;

import config.ApplicationConfig;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import me.soomin.user.controller.LoginController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
@Log4j
public class UserLoginControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp (){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Test
    public void testLoginController() throws Exception {
       log.info( mockMvc.perform(MockMvcRequestBuilders.get("/login"))
        .andReturn().getModelAndView().getViewName()
       );
    }

//    @Test
    public void testLoginControllerPost() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("loginId","로그인 테스트 아이디")
                .param("loginName","로그인 테스트 이름")
                .param("loginPassword","로그인 테스트 암호")
                .param("loginConfirmPassword","로그인 테스트 암호 확인")
                .param("loginEmail","로그인 테스트 이메일")
                .param("agreeIdSave","true")).andReturn().getModelAndView().getModelMap()
        );
    }


}
