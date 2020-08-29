package me.soomin.board.domain.pagination;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@ToString
@Getter
public class PageInfo {

    Criteria criteria;

    private int endPage;

    private int startPage;

    private int realEnd;

    boolean prev;

    boolean next;

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public PageInfo(Criteria criteria , int total) {
        this.criteria = criteria;

        this.endPage = (int)(Math.ceil(criteria.getPageNum() / 10.0 ) * 10);

        this.startPage = this.endPage - (10 -1) ;
        realEnd = (int)(Math.ceil( ((total * 1.0) / criteria.getAmount())) ); // 먼저 계산 처리 후 올림

        if(realEnd < this.endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
