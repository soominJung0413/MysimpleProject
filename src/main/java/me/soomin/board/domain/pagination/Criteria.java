package me.soomin.board.domain.pagination;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.util.UriComponentsBuilder;

@ToString
@Getter
@Setter
public class Criteria {

    private int pageNum;

    private int amount;

    private String type;

    private String keyword;

    public Criteria() {
        this(1,20);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String[] getTypeArr() {
        return type == null ? new String[] {} : type.split("");
    }

    public String getQueryString(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum",pageNum)
                .queryParam("amount",amount)
                .queryParam("type", type)
                .queryParam("keyword", keyword);

        return builder.toUriString();
    }
}
