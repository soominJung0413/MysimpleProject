package me.soomin.board.domain.dtd;

import lombok.Data;

//DTD
@Data
public class BoardModifyRequest {

    private Long boardNo;
    private String boardTitle;
    private String boardCategory;
    private String boardContent;
    private String userId;
}
