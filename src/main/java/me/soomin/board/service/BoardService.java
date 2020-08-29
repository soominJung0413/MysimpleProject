package me.soomin.board.service;

import me.soomin.board.domain.BoardInfoVO;
import me.soomin.board.domain.dtd.BoardModifyRequest;
import me.soomin.board.domain.dtd.BoardRegisterRequest;
import me.soomin.board.domain.pagination.Criteria;

import java.util.List;

public interface BoardService {

    public List<BoardInfoVO> readPagingList(Criteria criteria);

    public BoardInfoVO readBoardContent(Long boardNo);

    public List<BoardInfoVO> readBoardList();

    public List<BoardInfoVO> readFromUserId(String userId);

    public boolean insertBoard(BoardRegisterRequest boardRegisterRequest);

    public boolean insertBoardCategory(BoardRegisterRequest boardRegisterRequest);

    public Long insertBoardSelectKey(BoardRegisterRequest boardRegisterRequest);

    public Long insertSelectKeyCategory(BoardRegisterRequest boardRegisterRequest);

    public boolean updateBoard(BoardModifyRequest boardModifyRequest);

    public boolean deleteBoard(Long boardNo);

    public boolean updateReadCount(Long boardNo);

    public boolean updateLikeCount(Long boardNo);
}
