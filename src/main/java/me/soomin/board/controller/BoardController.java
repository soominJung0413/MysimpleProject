package me.soomin.board.controller;

import lombok.extern.log4j.Log4j;
import me.soomin.board.controller.rest.Message;
import me.soomin.board.domain.BoardInfoVO;
import me.soomin.board.domain.dtd.BoardDeleteRequest;
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
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/{userId}/write")
    public String provideBoardWriteForm(@ModelAttribute BoardRegisterRequest boardRegisterRequest, @PathVariable(name = "userId") String userId,
                                        HttpSession httpSession, RedirectAttributes redirectAttributes,
                                        Model model,@ModelAttribute Criteria criteria){
        log.info("유저 서비스 Get 요청 커멘드 객체는 빈 상태 여야함 :::::\n"+boardRegisterRequest);
        log.info(criteria);
                 UserInfoVO userInfoVO = (UserInfoVO) httpSession.getAttribute("userInfo");
                 if(userInfoVO.getUserId().equals(userId)){
                     boardRegisterRequest.setCriteria(criteria);
                     model.addAttribute("boardRegisterRequest",boardRegisterRequest);
                     return "board/write/form";
                 }
            httpSession.invalidate();
            redirectAttributes.addFlashAttribute("Success","Failed"+userInfoVO.getUserId());
            return "redirect:/";
    }

    @PostMapping("/{userId}/write")
    public String processBoardWriteForm(@ModelAttribute BoardRegisterRequest boardRegisterRequest, HttpSession httpSession,
                                        RedirectAttributes redirectAttributes, @PathVariable String userId){
        UserInfoVO userInfoVO = (UserInfoVO) httpSession.getAttribute("userInfo");
        log.info("글 등록 서비스 Post 요청 커멘트 객체 내용 :::"+boardRegisterRequest);
        log.info("세션에서 꺼내온 유저정보 :::"+userInfoVO);

        log.info("비교  :::::"+boardRegisterRequest.getUserId() + " / "+userInfoVO.getUserId());
        if(userInfoVO.getUserId().equals(boardRegisterRequest.getUserId())){
            boardService.insertBoardCategory(boardRegisterRequest);
            redirectAttributes.addFlashAttribute("Success","Write"+userInfoVO.getUserId());
            redirectAttributes.addFlashAttribute(boardRegisterRequest.getCriteria());
            return "redirect:/board/get";
        }
        httpSession.invalidate();
        redirectAttributes.addFlashAttribute("Success","Failed"+userInfoVO.getUserId());
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping(value = "/delete")
    public ResponseEntity<Message> deleteBoardContent(@RequestBody BoardDeleteRequest boardDeleteRequest,
                                                      Errors errors, HttpSession httpSession){
        log.info("딜리트 요청 수렴 ::::"+boardDeleteRequest);
        boolean result = boardService.deleteBoard(boardDeleteRequest.getBoardNo(),httpSession,errors);
        log.info("딜리트 요청 결과 ::::"+result);
        ResponseEntity<Message> report = null;

        Message deleteMessage = new Message();
        if(result){
            deleteMessage.setMessage("Succeed");
            report = ResponseEntity.ok(deleteMessage);
            log.info(report);
        }else {
            deleteMessage.setErrorMessage(
            errors.getAllErrors().stream().map(objectError -> objectError.getCodes()[0]).collect(Collectors.joining())
            );
            report = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(deleteMessage);
        }
        return report;
    }

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder){
        dataBinder.addValidators();
    }
}
