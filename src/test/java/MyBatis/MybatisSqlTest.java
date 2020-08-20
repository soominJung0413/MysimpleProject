package MyBatis;

import config.RootConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.user.domain.dtd.UserModifyRequest;
import me.soomin.user.domain.dtd.UserRegisterRequest;
import me.soomin.user.domain.vo.UserInfoVO;
import me.soomin.user.persistence.mapper.SimpleMapper;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@WebAppConfiguration
@Log4j
public class MybatisSqlTest {
        @Autowired
        private SimpleMapper simpleMapper;

//        @Test
    public void testExistMapper(){
            Assert.assertThat(simpleMapper, IsNull.notNullValue());

            log.info(simpleMapper);
        }

//        @Test
    public void testGetList(){
            Assert.assertThat(simpleMapper.getList(),IsNull.notNullValue());
            simpleMapper.getList();
        }
//        @Test
    public  void testInsert(){
            Integer insertCol = 0;

        UserRegisterRequest userRegisterRequest= new UserRegisterRequest();
        userRegisterRequest.setUserId("테스트 아이디6");
        userRegisterRequest.setUserName("테스트 이름6");
        userRegisterRequest.setUserPassword("테스트 암호6");

            insertCol = simpleMapper.insert(userRegisterRequest);

            log.info("인서트된 로우 :::::::::::::::::"+insertCol);

            Assert.assertThat(insertCol,IsNull.notNullValue());
        }

//    @Test
    public void testInsertSelectKey(){
        Long insertCol = 0L;

        UserRegisterRequest userRegisterRequest= new UserRegisterRequest();
        userRegisterRequest.setUserId("테스트 아이디7");
        userRegisterRequest.setUserName("테스트 이름7");
        userRegisterRequest.setUserPassword("테스트 암호7");

        insertCol = simpleMapper.insertSelectKey(userRegisterRequest);

        log.info("인서트된 로우 :::::::::::::::::"+insertCol+"가져온 PK ::::::::::::::::::::::::"+userRegisterRequest.getUserNo());

        Assert.assertThat(insertCol,IsNull.notNullValue());
    }

//    @Test
    public  void testGet(){
        UserInfoVO userInfoVO = simpleMapper.get(4L);


        Assert.assertThat(userInfoVO, IsNull.notNullValue());
    }

//    @Test
    public void testUpdate(){
        Integer updateCount = 0;

        Long userNo = 4L;

        UserInfoVO userInfoVO = simpleMapper.get(userNo);
        UserModifyRequest userModifyRequest = new UserModifyRequest();
        userModifyRequest.setUserNo(userNo);
        userModifyRequest.setUserId("변경된 아이디4");
        userModifyRequest.setUserName("변경된 이름4");
        userModifyRequest.setUserPassword("변경된 암호4");

        updateCount = simpleMapper.update(userModifyRequest);

        userInfoVO = simpleMapper.get(4L);

        log.info("변경된 로우 :::::::::::::::"+updateCount +
                " 변경된 데이터"+userInfoVO);
    }


//    @Test
    public void testDelete(){
        int deleteCount = simpleMapper.delete(11L);

        Assert.assertThat(deleteCount, Is.is(1));
    }
}
