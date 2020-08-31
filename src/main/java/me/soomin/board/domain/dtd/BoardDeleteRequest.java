package me.soomin.board.domain.dtd;

import lombok.Data;

@Data
public class BoardDeleteRequest {

    private Long boardNo;

    private String userId;
}
