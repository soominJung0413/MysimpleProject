package service;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.user.domain.dtd.UserModifyRequest;
import me.soomin.user.domain.dtd.UserRegisterRequest;
import me.soomin.user.domain.vo.UserInfoVO;
import me.soomin.user.service.UserService;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
@Log4j
public class UserServiceTests {

    @Autowired
    private UserService userService;

    //    @Test
    public void testGetNowTime(){
        Assert.assertThat(userService, IsNull.notNullValue());

        log.info(userService.getNowTime());
    }

//    @Test
    public void testGetUserInfo(){
        Assert.assertThat(userService, IsNull.notNullValue());

        log.info(userService.getUserInfoList());
    }

//    @Test
    public void testRegisterUserInfo(){
        Assert.assertThat(userService, IsNull.notNullValue());

        UserRegisterRequest userRegisterRequest= new UserRegisterRequest();
        userRegisterRequest.setUserId("서비스 테스트 아이디 2");
        userRegisterRequest.setUserName("서비스 테스트 이름 2");
        userRegisterRequest.setUserPassword("서비스 테스트 암호 2");

        boolean result = userService.registerUserInfo(userRegisterRequest);

        log.info(result);

        Assert.assertThat(result, Is.is(true));
    }

//    @Test
    public void testModifyUserInfo(){
        Assert.assertThat(userService, IsNull.notNullValue());
        Long userNo = 5L;
        UserInfoVO userInfoVO  = userService.readUserInfo(userNo);

        UserModifyRequest userModifyRequest = new UserModifyRequest();

        userModifyRequest.setUserName("변경된 테스트 이름");
        userModifyRequest.setUserPassword("변경된 테스트 암호");
        userModifyRequest.setUserId("변경된 테스트 아이디");

        boolean result = userService.modifyUserInfo(userModifyRequest);
        Assert.assertThat(result, Is.is(true));
    }

//    @Test
    public void testRegisterUserInfoGetKey(){
        Assert.assertThat(userService, IsNull.notNullValue());

        UserRegisterRequest userRegisterRequest= new UserRegisterRequest();
        userRegisterRequest.setUserId("서비스 테스트 아이디 3");
        userRegisterRequest.setUserName("서비스 테스트 이름 3");
        userRegisterRequest.setUserPassword("서비스 테스트 암호 3");

        Long RegisterRow_PK = userService.registerUserInfoGetKey(userRegisterRequest);

        log.info(RegisterRow_PK);

        Assert.assertThat(RegisterRow_PK, IsNot.not(-1));
    }

//    @Test
    public void testRemoveUserInfo(){
        Assert.assertThat(userService, IsNull.notNullValue());

        boolean result = userService.removeUserInfo(13L);

        log.info(result);

        Assert.assertThat(result, Is.is(true));
    }

}
