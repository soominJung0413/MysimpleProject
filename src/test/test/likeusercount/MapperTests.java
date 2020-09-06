package likeusercount;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.LikeCountUserVO;
import me.soomin.board.persistence.mappers.LikeCountUserMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@WebAppConfiguration
@Log4j
public class MapperTests {

    @Autowired
    private LikeCountUserMapper mapper;

//    @Test
    public void testExist(){
        Assert.assertThat(mapper, Matchers.notNullValue());
        log.info(mapper);
    }

//    @Test
    public void insertTest(){
        LikeCountUserVO vo = new LikeCountUserVO();
        vo.setBoardNo(32784l);
        vo.setUserNo(21l);
        int result = mapper.insert(vo);

        Assert.assertThat(result,Matchers.is(1));
    }

    @Test
    public void selectLikeUserNoTest(){
        LikeCountUserVO vo = new LikeCountUserVO();
        vo.setBoardNo(32784l);
        vo.setUserNo(21l);
        Long result = mapper.selectLikeUserNo(vo);
        log.info(result);
    }
}
