package me.soomin.comment.service;

import me.soomin.board.domain.pagination.Criteria;
import me.soomin.board.persistence.mappers.BoardMapper;
import me.soomin.comment.domain.CommentPageDTO;
import me.soomin.comment.domain.CommentVO;
import me.soomin.comment.persistence.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper mapper;

    @Autowired
    private BoardMapper boardMapper;


    @Override
    public CommentPageDTO readListWithPaging(Long boardNo, Criteria cri) {
        return  new CommentPageDTO(mapper.getListWithPaging(boardNo,cri),mapper.getCountComment(boardNo));
    }

    @Override
    public CommentVO read(Long commentNo) {
        return mapper.get(commentNo);
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public int register(CommentVO vo) {
        boardMapper.updateReplyCount(vo.getBoardNo(),1);
        if(1 == mapper.insert(vo)){
            return boardMapper.selectReplyCount(vo.getBoardNo());
        }
        return -1;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public int remove(Long commentNo) {
        CommentVO vo = mapper.get(commentNo);
        boardMapper.updateReplyCount(vo.getBoardNo(),-1);
        if(1 == mapper.delete(commentNo)){
            return  boardMapper.selectReplyCount(vo.getBoardNo());
        }
        return -1;
    }

    @Override
    public boolean modify(CommentVO vo) {
        return 1 == mapper.update(vo);
    }
}
