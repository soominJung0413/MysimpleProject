package me.soomin.user.persistence.mapper;

import me.soomin.user.domain.dtd.UserModifyRequest;
import me.soomin.user.domain.dtd.UserRegisterRequest;
import me.soomin.user.domain.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SimpleMapper {

    public String getNow();

    public List<UserInfoVO> getList();

    public UserInfoVO get(Long userNo);

    public UserInfoVO getFromId(String userId);

    public int insert(UserRegisterRequest userRegisterRequest);

    public Long insertSelectKey(UserRegisterRequest userRegisterRequest);

    public int update(UserModifyRequest userModifyRequest);

    public int delete(Long userNo);
}
