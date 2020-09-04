package aop;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.aop.LoggingAdvice;
import me.soomin.user.service.UserService;
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
public class TestAop {
    @Autowired
    private LoggingAdvice advice;
    @Autowired
    private UserService userService;

//    @Test
    public void testExist(){
        log.info(advice.getClass());
        log.info(advice);
    }


}
