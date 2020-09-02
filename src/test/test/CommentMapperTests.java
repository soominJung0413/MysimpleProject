import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.persistence.CommentMapper;
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
public class CommentMapperTests {

    @Autowired
    private CommentMapper commentMapper;

//   @Test
    public void isExists(){
        Assert.assertThat(commentMapper, IsNull.notNullValue());
        log.info(commentMapper.getList(32782L,new Criteria()));
    }

    @Test
    public void testGet(){
        Assert.assertThat(commentMapper, IsNull.notNullValue());
        log.info(commentMapper.get(2L));
    }
}
