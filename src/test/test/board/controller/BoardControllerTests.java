package board.controller;


import config.ApplicationConfig;
import lombok.extern.log4j.Log4j;
import me.soomin.board.controller.BoardController;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
@Log4j
public class BoardControllerTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BoardController boardController;

    private MockMvc mockMvc;


    @Before
    public void setUpMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//   @Test
   public void testBoardModify() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/modify")
        .param("amount","20").param("pageNum","1"))
        .andReturn().getModelAndView().getViewName());
   }

//    @Test
    public void testExistsMockMvc(){
        Assert.assertThat(mockMvc, IsNull.notNullValue());

        log.info(mockMvc);
    }

//    @Test
    public void testProvideBoardTable() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")).andReturn().getModelAndView().getModelMap());
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")).andReturn().getModelAndView().getViewName());
    }


}
