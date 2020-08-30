package me.soomin.comment.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {

    private Long commentNo;

    private Long boardNo;

    private String userId;

    private Date regdate;

    private Date updateDate;

    private String content;
}
