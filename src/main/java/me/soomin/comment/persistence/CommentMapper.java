package me.soomin.comment.persistence;


import me.soomin.comment.domain.CommentVO;

import java.util.List;

public interface CommentMapper {

    public List<CommentVO> getList();

    public CommentVO get(Long commentNo);
}
