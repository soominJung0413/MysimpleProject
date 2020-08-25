package me.soomin.board.domain.dtd;

import lombok.Data;

import java.util.Date;

//DTD
@Data
public class BoardRegisterRequest {

    private Long boardNo;
    private String boardTitle;
    private String boardCategory;
    private String boardContent;
    private String userId;

}
