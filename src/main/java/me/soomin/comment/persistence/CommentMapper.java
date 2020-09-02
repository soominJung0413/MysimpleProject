package me.soomin.comment.persistence;


import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    public List<CommentVO> getList(@Param("boardNo") Long boardNo, @Param("cri")Criteria cri);

    public CommentVO get(Long commentNo);

    public int insert(CommentVO vo);

    public int delete(@Param("commentNo") Long commentNo);

    public int update(CommentVO vo);
}
