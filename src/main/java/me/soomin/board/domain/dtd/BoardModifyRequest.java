package me.soomin.board.domain.dtd;

import lombok.Data;

import javax.validation.constraints.NotBlank;

//DTD
@Data
public class BoardModifyRequest {

    private Long boardNo;
    @NotBlank
    private String boardTitle;
    private String boardCategory;
    private String boardContent;
    private String userId;
}
