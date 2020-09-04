package me.soomin.comment.service;

import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentPageDTO;
import me.soomin.comment.domain.CommentVO;
import me.soomin.comment.persistence.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper mapper;


    @Override
    public CommentPageDTO readListWithPaging(Long boardNo, Criteria cri) {
        return  new CommentPageDTO(mapper.getListWithPaging(boardNo,cri),mapper.getCountComment(boardNo));
    }

    @Override
    public CommentVO read(Long commentNo) {
        return mapper.get(commentNo);
    }

    @Override
    public boolean register(CommentVO vo) {
        return 1 == mapper.insert(vo);
    }

    @Override
    public boolean remove(Long commentNo) {
        return 1 == mapper.delete(commentNo);
    }

    @Override
    public boolean modify(CommentVO vo) {
        return 1 == mapper.update(vo);
    }
}
