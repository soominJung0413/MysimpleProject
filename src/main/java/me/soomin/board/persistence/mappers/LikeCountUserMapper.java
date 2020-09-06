package me.soomin.board.persistence.mappers;

import me.soomin.board.domain.LikeCountUserVO;

public interface LikeCountUserMapper {

    public Long selectLikeUserNo(LikeCountUserVO vo);

    public int insert(LikeCountUserVO vo);

    public int deleteFromUserNo(Long userNo);

    public int deleteFromBoardNo(Long boardNo);
}
