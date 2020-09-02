package content.mybatis;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentVO;
import me.soomin.comment.persistence.CommentMapper;
import org.hamcrest.Matchers;
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
public class MybatisTests {

    @Autowired
    private CommentMapper mapper;

//    @Test
    public void testExist(){
        Assert.assertThat(mapper, IsNull.notNullValue());
    }

//    @Test
    public void getListTest(){
        Assert.assertThat(mapper, IsNull.notNullValue());

        mapper.getList(32782L,new Criteria()).forEach(vo -> log.info(vo));
    }

//    @Test
    public void getTest(){
        Assert.assertThat(mapper, IsNull.notNullValue());

        CommentVO vo = mapper.get(21L);

        Assert.assertThat(vo,IsNull.notNullValue());
    }

//    @Test
    public void testInsert(){
        Assert.assertThat(mapper, IsNull.notNullValue());

        CommentVO vo = new CommentVO();
        vo.setBoardNo(32782L);
        vo.setUserId("doli0413");
        vo.setContent("junit test");

        int result = mapper.insert(vo);

        Assert.assertThat(result, Matchers.is(1));
    }

//    @Test
    public void testDelete(){
        Assert.assertThat(mapper, IsNull.notNullValue());

        Long commentNo = 24L;

        int result = mapper.delete(commentNo);

        Assert.assertThat(result,Matchers.is(1));
    }

//    @Test
    public void testUpdate(){
        Assert.assertThat(mapper,IsNull.notNullValue());

        CommentVO vo = mapper.get(23L);
        vo.setContent("업데이트 댓글 내용");

        int result = mapper.update(vo);

        Assert.assertThat(result, Matchers.is(1));
    }
}
