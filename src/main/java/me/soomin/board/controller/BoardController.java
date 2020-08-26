package me.soomin.board.controller;

import me.soomin.board.domain.BoardInfoVO;
import me.soomin.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String provideBoardTable(Model model){
        List<BoardInfoVO> boardInfoVO = boardService.readBoardList();
        model.addAttribute("boardInfoVO",boardInfoVO);

        return "board/get/list";
    }

    @GetMapping(value = "/{boardNo}/read")
    public String provideBoardContent(@PathVariable("boardNo") Long boardNo,Model model){
            BoardInfoVO readBoardContent = boardService.readBoardContent(boardNo);
            model.addAttribute("readBoardContent", readBoardContent);

            return "board/read/content";
    }

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder){
        dataBinder.addValidators();
    }
}
