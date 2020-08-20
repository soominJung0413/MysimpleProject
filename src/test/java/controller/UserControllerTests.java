package controller;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
public class UserControllerTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUpMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Test
    public void formTest() throws Exception{

        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/user/create/form")).andReturn().getModelAndView().getModelMap()
        );
    }

//    @Test
    public void testRegisterSevice() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.post("/user/create/form")
                        .param("userId","컨트롤러 테스트 아이디")
                        .param("userName","컨트롤러 테스트 이름")
                        .param("userPassword","컨트롤러 테스트 암호")
                ).andReturn().getModelAndView().getViewName()
        );
    }

//    @Test
    public void testProvideModifyForm() throws Exception{
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/user/modify/form")).andReturn().getModelAndView().getViewName()
        );
    }

//    @Test
    public void testModifyUserInfo() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.post("/user/modify/form")
                .param("userId","컨트롤러 테스트 수정아이디")
                 .param("userName","컨트롤러 테스트 아이디")
                 .param("userPassword","컨트롤러 테스트 아이디")
                ).andReturn().getModelAndView().getViewName()
        );
    }

//    @Test
    public void testProvideRemoveForm() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/user/delete/form/1"))
                .andReturn().getModelAndView().getViewName()
        );
    }

    @Test
    public void testRemoveUserInfo() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.post("/user/delete/form/1")
                .param("userPassword","123")
                        .param("confirmPassword","123")
                )
        );
    }


}
