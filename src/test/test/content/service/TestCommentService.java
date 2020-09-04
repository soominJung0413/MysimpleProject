package content.service;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentPageDTO;
import me.soomin.comment.domain.CommentVO;
import me.soomin.comment.service.CommentService;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
@Log4j
public class TestCommentService {

    @Autowired
    private CommentService service;

    @Test
    public void testReadListWithPaging(){
        CommentPageDTO dto = service.readListWithPaging(32782l,new Criteria(1,10));

        log.info(dto.getCount());
        dto.getList().forEach(vo -> log.info(vo));
    }

//    @Test
    public void testExist(){
        Assert.assertThat(service, IsNull.notNullValue());
    }



//    @Test
    public void testRead(){
        Assert.assertThat(service, IsNull.notNullValue());

        CommentVO vo = service.read(23L);

        Assert.assertThat(vo,Matchers.notNullValue());
    }

//    @Test
    public void testRegister(){
        CommentVO vo = new CommentVO();
        vo.setContent("junit 등록 서비스 테스트 ");
        vo.setUserId("doli0413");
        vo.setBoardNo(32781L);

        boolean result = service.register(vo);

        Assert.assertThat(result,Matchers.is(true));
    }

//    @Test
    public void testRemove(){
        boolean result = service.remove(21l);
        Assert.assertThat(result, Matchers.is(true));
    }

//    @Test
    public void testUpdate(){
        CommentVO vo = new CommentVO();
        vo.setCommentNo(22l);
        vo.setContent("junit 수정 서비스 테스트 ");
        vo.setUserId("doli0413");
        vo.setBoardNo(32781L);

        boolean result = service.modify(vo);

        Assert.assertThat(result,Matchers.is(true));
    }
}
