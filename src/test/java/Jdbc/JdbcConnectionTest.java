package Jdbc;

import config.RootConfig;
import lombok.extern.log4j.Log4j;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@WebAppConfiguration
@Log4j
public class JdbcConnectionTest {
    @Value("${dbcp.url}")
    private String url;
    @Value("${dbcp.user}")
    private String username;
    @Value("${dbcp.password}")
    private String password;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
        }
    }

//    @Test
    public void JdbcConnection(){
        try(Connection con = DriverManager.getConnection(url,username,password)){

            log.info(
                    "Connection ::::::::::::::::: "+con
            );
            Assert.assertThat(con, IsNull.notNullValue());
        }catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }
}
