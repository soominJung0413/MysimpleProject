package me.soomin.board.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//VO
@Data
public class BoardInfoVO {

    private Long boardNo;
    private String boardTitle;
    private String boardCategory;
    private String boardContent;
    private Date regdate;
    private Date updateDate;
    private String userId;
    private int readCount;
    private int likeCount;
}
