package board.service;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.dtd.BoardModifyRequest;
import me.soomin.board.domain.dtd.BoardRegisterRequest;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.board.service.BoardService;
import org.hamcrest.Matchers;
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
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
@Log4j
public class TestServiceImpl {

    @Autowired
    private BoardService boardService;

    @Test
    public void testReadTotalCount(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        int result = boardService.readTotalCount(new Criteria());

        Assert.assertThat(result,Matchers.greaterThan(-1));
    }

//    @Test
    public void testReadBoardNo(){
        Assert.assertThat(boardService, IsNull.notNullValue());

//        log.info(boardService.readBoardNo(4L));
    }

//    @Test
    public void testReadBoardList(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        log.info(boardService.readBoardList());
    }

//    @Test
    public void testReadFromUserId(){
        Assert.assertThat(boardService, IsNull.notNullValue());

        log.info(boardService.readFromUserId("doli0413"));
    }

//    @Test
    public void testInsertBoard(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        BoardRegisterRequest boardRegisterRequest = new BoardRegisterRequest();
        boardRegisterRequest.setUserId("doli0413");
        boardRegisterRequest.setBoardTitle("테스트 제목");
        boardRegisterRequest.setBoardContent("테스트 내용");

        boolean result = boardService.insertBoard(boardRegisterRequest);

        log.info(result);

        Assert.assertThat(result, Is.is(true));
    }

//    @Test
    public void testInsertBoardCategory(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        BoardRegisterRequest boardRegisterRequest = new BoardRegisterRequest();
        boardRegisterRequest.setUserId("doli0413");
        boardRegisterRequest.setBoardCategory("테스트 카테고리");
        boardRegisterRequest.setBoardTitle("테스트 제목");
        boardRegisterRequest.setBoardContent("테스트 내용");

        boolean result = boardService.insertBoardCategory(boardRegisterRequest);

        log.info(result);

        Assert.assertThat(result, Is.is(true));
    }

//    @Test
    public void testInsertBoardSelectKey(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        BoardRegisterRequest boardRegisterRequest = new BoardRegisterRequest();
        boardRegisterRequest.setUserId("doli0413");
        boardRegisterRequest.setBoardTitle("테스트 제목");
        boardRegisterRequest.setBoardContent("테스트 내용");


        Long pk = boardService.insertBoardSelectKey(boardRegisterRequest);

        log.info(pk);

        Assert.assertThat(pk, Matchers.greaterThan(7L));
    }

//    @Test
    public void testInsertSelectKeyCategory(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        BoardRegisterRequest boardRegisterRequest = new BoardRegisterRequest();
        boardRegisterRequest.setUserId("doli0413");
        boardRegisterRequest.setBoardCategory("테스트 카테고리");
        boardRegisterRequest.setBoardTitle("테스트 제목");
        boardRegisterRequest.setBoardContent("테스트 내용");

        Long result = boardService.insertSelectKeyCategory(boardRegisterRequest);
        Assert.assertEquals(result, Matchers.greaterThan(10L));
    }

//    @Test
    public void testUpdateBoard(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        BoardModifyRequest boardModifyRequest = new BoardModifyRequest();
        boardModifyRequest.setBoardNo(11L);
        boardModifyRequest.setUserId("doli0413");
        boardModifyRequest.setBoardTitle("변경된 제목");
        boardModifyRequest.setBoardCategory("변경된 카테고리");
        boardModifyRequest.setBoardContent("변경된 내용");

        boolean result = boardService.updateBoard(boardModifyRequest);

        Assert.assertThat(result,Is.is(true));
    }

//    @Test
    public void testDeleteBoard(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        boolean result = boardService.deleteBoard(11L);

        Assert.assertThat(result,Is.is(true));
    }

//    @Test
    public void testUpdateReadCount(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        boolean result = boardService.updateReadCount(10L);

        Assert.assertThat(result, Is.is(true));
    }

//    @Test
    public void testUpdateLikeCount(){
        Assert.assertThat(boardService,IsNull.notNullValue());

        boolean result= boardService.updateLikeCount(10L);


        Assert.assertThat(result , Is.is(true));
    }

}
