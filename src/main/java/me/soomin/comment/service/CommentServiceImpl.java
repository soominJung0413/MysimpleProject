package me.soomin.comment.service;

import lombok.extern.log4j.Log4j;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentVO;
import me.soomin.comment.persistence.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;

@Service
@Log4j
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper mapper;

    @Override
    public List<CommentVO> readList(Long boardNo, Criteria cri) {
        log.info("CommentService - readList .....");
        return mapper.getList(boardNo,cri);
    }

    @Override
    public CommentVO read(Long commentNo) {
        log.info("CommentService - read.....");
        return mapper.get(commentNo);
    }

    @Override
    public boolean register(CommentVO vo) {
        log.info("CommentService - Register....");
        return 1 == mapper.insert(vo);
    }

    @Override
    public boolean remove(Long commentNo) {
        log.info("CommentService - Remove");
        return 1 == mapper.delete(commentNo);
    }

    @Override
    public boolean modify(CommentVO vo) {
        log.info("CommentService = Modify");
        return 1 == mapper.update(vo);
    }
}
