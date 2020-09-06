package me.soomin.board.service;

import me.soomin.board.domain.LikeCountUserVO;
import me.soomin.board.persistence.mappers.BoardMapper;
import me.soomin.board.persistence.mappers.LikeCountUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class LikeCountUserServiceImpl implements LikeCountUserService{

    @Autowired
    private LikeCountUserMapper mapper;

    @Autowired
    private BoardMapper boardMapper;

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public int registerLikeCount(LikeCountUserVO vo) {

        int result = mapper.insert(vo);

        boardMapper.updateLikeCount(vo.getBoardNo(),1);

        if(result == 1){
            return boardMapper.selectLikeCount(vo.getBoardNo());
        }
        return -1;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public int removeLikeCount(LikeCountUserVO vo) {
        int result = mapper.delete(vo);

            boardMapper.updateLikeCount(vo.getBoardNo(), -1);

        if(result == 1){
            return boardMapper.selectLikeCount(vo.getBoardNo());
        }
        return -1;
    }
}
