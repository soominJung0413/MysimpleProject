package me.soomin.board.domain.dtd;

import lombok.Data;
import me.soomin.board.domain.pagination.Criteria;

import javax.validation.constraints.NotBlank;
import java.util.Date;

//DTD
@Data
public class BoardRegisterRequest extends Criteria{

    private Long boardNo;
    @NotBlank
    private String boardTitle;
    private String boardCategory;
    private String boardContent;
    private String userId;

}
