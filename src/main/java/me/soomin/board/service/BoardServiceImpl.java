package me.soomin.board.service;

import me.soomin.board.domain.BoardInfoVO;
import me.soomin.board.domain.dtd.BoardModifyRequest;
import me.soomin.board.domain.dtd.BoardRegisterRequest;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.board.persistence.mappers.BoardMapper;
import me.soomin.user.domain.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{



    @Autowired
    private BoardMapper boardMapper;

    @Override
    public int readTotalCount(Criteria criteria) {
        return boardMapper.getTotalCount(criteria);
    }

    @Override
    public List<BoardInfoVO> readPagingList(Criteria criteria) {
        return boardMapper.getListPaging(criteria);
    }

    @Override
    @Transactional(rollbackFor = SQLException.class,propagation = Propagation.REQUIRES_NEW)
    public BoardInfoVO readBoardContent(Long boardNo) {
    BoardInfoVO boardInfoVO= boardMapper.get(boardNo);
    this.updateReadCount(boardNo);
        return boardInfoVO;
    }

    @Override
    public List<BoardInfoVO> readBoardList() {
        return boardMapper.getList();
    }

    @Override
    public  List<BoardInfoVO> readFromUserId(String userId) {
        return boardMapper.getFromId(userId);
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public boolean insertBoard(BoardRegisterRequest boardRegisterRequest) {
        return 1 == boardMapper.insert(boardRegisterRequest);
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public boolean insertBoardCategory(BoardRegisterRequest boardRegisterRequest) {
        return 1 == boardMapper.insertCategory(boardRegisterRequest);
    }

    @Override
    public Long insertBoardSelectKey(BoardRegisterRequest boardRegisterRequest) {
        boardMapper.insertSelectKey(
                boardRegisterRequest
        );

        return boardRegisterRequest.getBoardNo();
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public Long insertSelectKeyCategory(BoardRegisterRequest boardRegisterRequest) {
        boardMapper.insertSelectKeyCategory(
          boardRegisterRequest
        );

        return boardRegisterRequest.getBoardNo();
    }

    @Override
    public boolean updateBoard(BoardModifyRequest boardModifyRequest) {
        return 1 == boardMapper.update(boardModifyRequest);
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public boolean deleteBoard(Long boardNo, HttpSession session)
    {
        BoardInfoVO boardInfoVO = boardMapper.get(boardNo);
        if(boardInfoVO == null){
            return false;
        }
        try{
           UserInfoVO userInfoVO= (UserInfoVO)session.getAttribute("userInfo");
            if( ! (boardInfoVO.getUserId().equals(userInfoVO.getUserId())) ){
                return false;
            }
        }catch(NullPointerException e){
            return false;
        }
        return 1 == boardMapper.delete(boardNo);
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class},propagation = Propagation.MANDATORY)
    public boolean updateReadCount(Long boardNo) {
        return 1 == boardMapper.updateReadCount(boardNo);
    }

    @Override
    @Transactional(rollbackFor = {SQLException.class})
    public boolean updateLikeCount(Long boardNo) {
        return 1 == boardMapper.updateLikeCount(boardNo);
    }
}
