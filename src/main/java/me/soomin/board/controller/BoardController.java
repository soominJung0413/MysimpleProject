package me.soomin.board.controller;

import lombok.extern.log4j.Log4j;
import me.soomin.board.controller.rest.Message;
import me.soomin.board.domain.BoardInfoVO;
import me.soomin.board.domain.dtd.BoardDeleteRequest;
import me.soomin.board.domain.dtd.BoardModifyRequest;
import me.soomin.board.domain.dtd.BoardRegisterRequest;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.board.domain.pagination.PageInfo;
import me.soomin.board.service.BoardService;
import me.soomin.user.domain.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/board")
@Log4j
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String provideBoardTable(Model model,@ModelAttribute Criteria criteria){
        log.info("게시물 목록페이지 요청:::::"+criteria);
        PageInfo pageInfo = new PageInfo(criteria,boardService.readTotalCount(criteria));
        log.info("페이지네이션 정보 :::::"+pageInfo.getStartPage());
        List<BoardInfoVO> boardInfoVO = boardService.readPagingList(criteria);
        model.addAttribute("boardInfoVO",boardInfoVO);
        model.addAttribute("pageInfo",pageInfo);

        return "board/get/list";
    }

    @GetMapping(value = "/read/{boardNo}")
    public String provideBoardContent(@PathVariable("boardNo") Long boardNo,Model model, @ModelAttribute  Criteria criteria){
            log.info("게시글 세부내용 확인 요청:::"+boardNo);
            log.info("넘어온 페이지네이션 정보:::"+criteria);
            BoardInfoVO readBoardContent = boardService.readBoardContent(boardNo);
            model.addAttribute("readBoardContent", readBoardContent);

            return "board/read/content";
    }

    @GetMapping("/write/{userId}")
    public String provideBoardWriteForm(@ModelAttribute BoardRegisterRequest boardRegisterRequest, @PathVariable(name = "userId") String userId,
                                        HttpSession httpSession, RedirectAttributes redirectAttributes,
                                        Model model){
        log.info("유저 서비스 Get 요청 커멘드 객체는 빈 상태 여야함 :::::\n"+boardRegisterRequest);
                 UserInfoVO userInfoVO = (UserInfoVO) httpSession.getAttribute("userInfo");
                 if(userInfoVO.getUserId().equals(userId)){
                     return "board/write/form";
                 }
            httpSession.invalidate();
            redirectAttributes.addFlashAttribute("Success","Failed"+userInfoVO.getUserId());
            return "redirect:/board/get"+boardRegisterRequest.getQueryString();
    }

    @PostMapping("/write/{userId}")
    public String processBoardWriteForm(@ModelAttribute BoardRegisterRequest boardRegisterRequest, HttpSession httpSession,
                                        RedirectAttributes redirectAttributes, @PathVariable String userId){
        UserInfoVO userInfoVO = (UserInfoVO) httpSession.getAttribute("userInfo");
        log.info("글 등록 서비스 Post 요청 커멘트 객체 내용 :::"+boardRegisterRequest);
        log.info("세션에서 꺼내온 유저정보 :::"+userInfoVO);

        log.info("비교  :::::"+boardRegisterRequest.getUserId() + " / "+userInfoVO.getUserId());
        if(userInfoVO.getUserId().equals(boardRegisterRequest.getUserId())){
            boardService.insertBoardCategory(boardRegisterRequest);
            redirectAttributes.addFlashAttribute("Success","Write"+userInfoVO.getUserId());
            return "redirect:/board/get"+boardRegisterRequest.getQueryString();
        }
        httpSession.invalidate();
        redirectAttributes.addFlashAttribute("Success","Failed"+userInfoVO.getUserId());
        return "redirect:/";
    }

    @RequestMapping(value = "/modify/{boardNo}",method = RequestMethod.GET)
    public String provideModifyForm(@ModelAttribute Criteria criteria, @PathVariable("boardNo") Long boardNo, @ModelAttribute BoardModifyRequest boardModifyRequest, HttpSession session){
        log.info("글 수정 폼 제공 ::::"+boardModifyRequest);
            UserInfoVO userInfoVO = (UserInfoVO) session.getAttribute("userInfo");
            log.info("요청한 세션 아이디 :::" + userInfoVO.getUserId());
            log.info("넘어온 페이지 정보 "+criteria);

        BoardInfoVO boardInfoVO = boardService.readBoardContent(boardNo);
        boardModifyRequest.setBoardNo(boardInfoVO.getBoardNo());
        boardModifyRequest.setBoardTitle(boardInfoVO.getBoardTitle());
        boardModifyRequest.setBoardCategory(boardInfoVO.getBoardCategory());
        boardModifyRequest.setBoardContent(boardInfoVO.getBoardContent());
        boardModifyRequest.setUserId(boardInfoVO.getUserId());
        boardModifyRequest.setAmount(criteria.getAmount());
        boardModifyRequest.setKeyword(criteria.getKeyword());
        boardModifyRequest.setPageNum(criteria.getPageNum());
        boardModifyRequest.setType(criteria.getType());


        log.info("글 수정 폼 커맨드 객체 내용 :::"+boardModifyRequest.getKeyword()
        +" / "+boardModifyRequest.getQueryString());

        return "board/modify/form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modify/{boardNo}")
    public String processModifyForm(@Valid @ModelAttribute BoardModifyRequest boardModifyRequest, Errors errors,
                                    RedirectAttributes redirectAttributes,HttpSession session){
        log.info("글 수정 폼 커맨드 객체 내용 :::"+boardModifyRequest.getKeyword()
                +" / "+boardModifyRequest.getQueryString());

        if(errors.hasErrors()){
            return "board/modify/form";
        }

        UserInfoVO userInfoVO = (UserInfoVO) session.getAttribute("userInfo");

            if (userInfoVO.getUserId().equals(boardModifyRequest.getUserId())) {
                boardService.updateBoard(boardModifyRequest);
                redirectAttributes.addFlashAttribute("Success","Modify"+boardModifyRequest.getUserId());
                return "redirect:/board/get"+boardModifyRequest.getQueryString();
            }
            session.invalidate();
            redirectAttributes.addFlashAttribute("Success", "Failed" + userInfoVO.getUserId());
            return "redirect:/";

    }

    @ResponseBody
    @DeleteMapping(value = "/delete",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Message> deleteBoardContent(@RequestBody BoardDeleteRequest boardDeleteRequest,
                                                      HttpSession httpSession){
        log.info("딜리트 요청 수렴 ::::"+boardDeleteRequest);
        boolean result = boardService.deleteBoard(boardDeleteRequest.getBoardNo(),httpSession);
        log.info("딜리트 요청 결과 ::::"+result);

        Message message = new Message();
        message.setMessage("SuccessDelete");

        return result == true? new ResponseEntity<Message>(message, HttpStatus.OK) : new ResponseEntity<Message>(HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder){
        dataBinder.addValidators();
    }
}
