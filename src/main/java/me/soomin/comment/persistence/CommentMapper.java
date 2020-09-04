package me.soomin.comment.persistence;


import me.soomin.board.domain.pagination.Criteria;
import me.soomin.comment.domain.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    public List<CommentVO> getListWithPaging(@Param("boardNo") Long boardNo, @Param("cri")Criteria cri);

    public int getCountComment(@Param("boardNo") Long boardNo);

    public CommentVO get(Long commentNo);

    public int insert(CommentVO vo);

    public int delete(@Param("commentNo") Long commentNo);

    public int update(CommentVO vo);
}
