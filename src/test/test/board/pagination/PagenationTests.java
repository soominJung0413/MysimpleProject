package board.pagination;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.board.persistence.mappers.BoardMapper;
import me.soomin.board.service.BoardService;
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
public class PagenationTests {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardService boardService;

//    @Test
    public void testPagination(){
        Assert.assertThat(boardMapper, IsNull.notNullValue());
        boardMapper.getListPaging(new Criteria())
        .forEach(boardInfoVO -> log.info(boardInfoVO));
    }

//    @Test
    public void testListPaging(){
        Assert.assertThat(boardService,IsNull.notNullValue());
        boardService.readPagingList(new Criteria())
                .forEach(boardInfoVO -> log.info(boardInfoVO));
    }
}
