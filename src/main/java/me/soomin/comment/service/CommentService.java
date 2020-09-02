package me.soomin.comment.service;

import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    public List<CommentVO> readList(Long boardNo, Criteria cri);

    public CommentVO read(Long commentNo);

    public boolean register(CommentVO vo);

    public boolean remove(@Param("commentNo") Long commentNo);

    public boolean modify(CommentVO vo);
}
