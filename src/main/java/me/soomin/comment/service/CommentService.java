package me.soomin.comment.service;

import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentPageDTO;
import me.soomin.comment.domain.CommentVO;
import org.apache.ibatis.annotations.Param;

public interface CommentService {

    public CommentPageDTO readListWithPaging(Long boardNo, Criteria cri);

    public CommentVO read(Long commentNo);

    public int register(CommentVO vo);

    public int remove(@Param("commentNo") Long commentNo);

    public boolean modify(CommentVO vo);
}
