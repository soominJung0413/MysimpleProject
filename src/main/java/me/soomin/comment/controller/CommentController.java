package me.soomin.comment.controller;


import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentPageDTO;
import me.soomin.comment.domain.CommentVO;
import me.soomin.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replies")
@Log4j
public class CommentController {

    @Autowired
    private CommentService service;

    @GetMapping(value = "/boardNo/page/{boardNo}/{page}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<CommentPageDTO> provideCommentList(@PathVariable("boardNo") Long boardNo, @PathVariable("page") int page){
        log.info("CommentController = CommentList");
        Criteria cri = new Criteria(page,10);
        log.info(cri);
        CommentPageDTO dto =  service.readListWithPaging(boardNo,cri);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/commentNo/{commentNo}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentVO> provideComment(@PathVariable("commentNo") Long commentNo){
        log.info("CommentController = Comment");
        return ResponseEntity.ok(service.read(commentNo));
    }

    @PostMapping(value = "/new", consumes = "application/json; charset=utf-8",
    produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> processRegister(@RequestBody CommentVO vo){
        log.info("CommentController = Register....");
        int result = service.register(vo);

        return result != -1 ? ResponseEntity.ok(String.valueOf(result)) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/commentNo/{commentNo}",method = {RequestMethod.PUT,RequestMethod.PATCH},
            consumes = {"application/json; charset=utf8"},produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> processModify(@PathVariable("commentNo") Long commentNo,@RequestBody CommentVO vo){
        log.info("CommentController = Modify......");
        vo.setCommentNo(commentNo);
        boolean result = service.modify(vo);
        return result == true ? ResponseEntity.ok("Success") : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    @DeleteMapping(value = "commentNo/{commentNo}",produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> processRemove(@PathVariable("commentNo") Long commentNo){
        log.info("CommentController = Remove......");
        int result = service.remove(commentNo);

        return result != -1 ? ResponseEntity.ok(String.valueOf(result)) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
