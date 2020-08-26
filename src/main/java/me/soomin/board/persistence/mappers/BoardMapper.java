package me.soomin.board.persistence.mappers;


import me.soomin.board.domain.BoardInfoVO;
import me.soomin.board.domain.dtd.BoardModifyRequest;
import me.soomin.board.domain.dtd.BoardRegisterRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface BoardMapper {

    public BoardInfoVO get(Long boardNo);

    public List<BoardInfoVO> getList();

    public  List<BoardInfoVO> getFromId(String userId);

    public int insert(BoardRegisterRequest boardRegisterRequest);

    public int insertCategory(BoardRegisterRequest boardRegisterRequest);

    public int insertSelectKey(BoardRegisterRequest boardRegisterRequest);

    public int insertSelectKeyCategory(BoardRegisterRequest boardRegisterRequest);

    public int update(BoardModifyRequest boardModifyRequest);

    public int delete(Long boardNo);

    public int updateReadCount(Long boardNo);

    public int updateLikeCount(Long boardNo);
}
