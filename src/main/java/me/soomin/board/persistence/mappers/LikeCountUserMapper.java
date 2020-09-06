package me.soomin.board.persistence.mappers;

import me.soomin.board.domain.LikeCountUserVO;

public interface LikeCountUserMapper {


    public int insert(LikeCountUserVO vo);

    public int delete(LikeCountUserVO vo);
}
