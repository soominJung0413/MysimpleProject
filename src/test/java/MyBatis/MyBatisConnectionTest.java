package MyBatis;

import config.RootConfig;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@WebAppConfiguration
@Log4j
public class MyBatisConnectionTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void testMyBatisComponents(){
        Assert.assertThat(sqlSessionFactory, IsNull.notNullValue());
        Assert.assertThat(sqlSessionTemplate, IsNull.notNullValue());

        log.info("SQL SessionFactory .... "+sqlSessionFactory);
        log.info("SQL sessionTemplate.............."+sqlSessionTemplate);
    }
}
