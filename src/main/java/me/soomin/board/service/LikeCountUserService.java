package me.soomin.board.service;

import me.soomin.board.domain.LikeCountUserVO;

public interface LikeCountUserService {


    public int registerLikeCount(LikeCountUserVO vo);

    public int removeLikeCount(LikeCountUserVO vo);
}
