package me.soomin.board.persistence.mappers;


import me.soomin.board.domain.BoardInfoVO;
import me.soomin.board.domain.dtd.BoardModifyRequest;
import me.soomin.board.domain.dtd.BoardRegisterRequest;
import me.soomin.board.domain.pagination.Criteria;
import me.soomin.board.domain.pagination.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BoardMapper {

    public int getTotalCount(Criteria criteria);

    public List<BoardInfoVO> getListPaging(Criteria criteria);

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

    public int updateReplyCount(@Param("boardNo") Long boardNo,@Param("count") int count);

    public int selectReplyCount(Long boarNo);

    public int updateLikeCount(@Param("boardNo") Long boardNo,@Param("count") int count);

    public int selectLikeCount(Long boarNo);
}
