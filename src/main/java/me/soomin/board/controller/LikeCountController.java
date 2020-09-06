package me.soomin.board.controller;

import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.LikeCountUserVO;
import me.soomin.board.service.LikeCountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/likeCounts")
@Log4j
public class LikeCountController {

    @Autowired
    private LikeCountUserService service;

    @PutMapping(value = "/{boardNo}/{userNo}",produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> processRegister(@PathVariable("boardNo") Long boardNo, @PathVariable("userNo") Long userNo){
        LikeCountUserVO vo = new LikeCountUserVO();
        vo.setBoardNo(boardNo);
        vo.setUserNo(userNo);

        int result = service.registerLikeCount(vo);

        log.info(result);

        return result != -1 ? ResponseEntity.ok(String.valueOf(result)) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(value = "/{boardNo}/{userNo}",produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> processDelete(@PathVariable("boardNo") Long boardNo, @PathVariable("userNo") Long userNo){
        LikeCountUserVO vo = new LikeCountUserVO();
        vo.setBoardNo(boardNo);
        vo.setUserNo(userNo);

        int result = service.removeLikeCount(vo);

        log.info(result);

        return result != -1 ? ResponseEntity.ok(String.valueOf(result)) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
