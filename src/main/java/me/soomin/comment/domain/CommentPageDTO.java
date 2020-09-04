package me.soomin.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CommentPageDTO {

    private List<CommentVO> list;
    private int count;
}
