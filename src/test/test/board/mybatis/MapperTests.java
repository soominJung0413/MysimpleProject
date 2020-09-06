package board.mybatis;

import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.BoardInfoVO;
import me.soomin.board.domain.dtd.BoardModifyRequest;
import me.soomin.board.domain.dtd.BoardRegisterRequest;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.board.persistence.mappers.BoardMapper;
import me.soomin.user.persistence.mapper.SimpleMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
@Log4j
public class MapperTests {

    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private SimpleMapper simpleMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


//    @Test
    public void testGetTotalCount(){
        Assert.assertThat(boardMapper,IsNull.notNullValue());
        int result = boardMapper.getTotalCount(new Criteria());

        Assert.assertThat(result,Matchers.greaterThan(-1));
    }

//    @Test
    public void checkWiring(){
        Assert.assertThat(boardMapper, IsNull.notNullValue());
        log.info(boardMapper);
        log.info(sqlSessionFactory.getConfiguration().getMapperRegistry().getMappers());

    }
//    @Test
    public void getListTest(){
        Assert.assertThat(boardMapper, IsNull.notNullValue());
        log.info(boardMapper.getList());
    }
//    @Test
    public void getTest(){
        Assert.assertThat(boardMapper, IsNull.notNullValue());
        log.info(boardMapper.get(2L));
    }

//    @Test
    public void getFromeIdTest(){
        Assert.assertThat(boardMapper, IsNull.notNullValue());
        log.info(boardMapper.getFromId("doli0413"));
    }
//    @Test
    public void deleteTest(){
        Assert.assertThat(boardMapper, IsNull.notNullValue());
        int result = boardMapper.delete(3L);
        log.info(result);
        Assert.assertThat(result, Is.is(1));
    }

//    @Test
    public void insertTest(){
        Assert.assertThat(boardMapper,IsNull.notNullValue());
        BoardRegisterRequest boardRegisterRequest = new BoardRegisterRequest();
        boardRegisterRequest.setBoardTitle("테스트 제목");
        boardRegisterRequest.setBoardCategory("테스트 카테고리");
        boardRegisterRequest.setBoardContent("테스트 내용");
        boardRegisterRequest.setUserId("doli0413");
//        int result = boardMapper.insert(boardRegisterRequest);
        int result = boardMapper.insertCategory(boardRegisterRequest);
        Assert.assertThat(result, Is.is(1));
    }

//    @Test
    public void insertSelectKey(){
        Assert.assertThat(boardMapper,IsNull.notNullValue());
        BoardRegisterRequest boardRegisterRequest = new BoardRegisterRequest();
        boardRegisterRequest.setBoardTitle("테스트 제목");
        boardRegisterRequest.setBoardCategory("테스트 카테고리");
        boardRegisterRequest.setBoardContent("테스트 내용");
        boardRegisterRequest.setUserId("doli0413");
//        int result = boardMapper.insertSelectKey(boardRegisterRequest);
        int result = boardMapper.insertSelectKeyCategory(boardRegisterRequest);

        log.info(result);
        log.info(boardRegisterRequest.getBoardNo());
        Assert.assertThat(result, IsNot.not(0));
    }

//    @Test
    public void updateTest(){
        Assert.assertThat(boardMapper,IsNull.notNullValue());
        BoardModifyRequest boardModifyRequest = new BoardModifyRequest();
        boardModifyRequest.setUserId("doldifyRequest boardModifyRi0413");
        boardModifyRequest.setBoardTitle("수정된 타이틀");
        boardModifyRequest.setBoardCategory("수정된 카테고리");
        boardModifyRequest.setBoardContent("수정된 제목");
        boardModifyRequest.setBoardNo(10L);

        int result = boardMapper.update(boardModifyRequest);
        Assert.assertThat(result,Is.is(1));
        log.info(result);
    }

//    @Test
    public void testReadCount(){
        Assert.assertThat(boardMapper,IsNull.notNullValue());
        boardMapper.updateReadCount(4L);
        BoardInfoVO boardInfoVO = boardMapper.get(4L);
        int readCount = boardInfoVO.getReadCount();
        log.info(boardInfoVO.getReadCount());

        Assert.assertThat(readCount, Matchers.greaterThan(2));
    }


}
