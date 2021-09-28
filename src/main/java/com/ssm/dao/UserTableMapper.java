package com.ssm.dao;

import com.ssm.domain.UserTable;

import java.util.List;

/**
 * @author STARS
 */
public interface UserTableMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    UserTable selectByPrimaryKey(Integer userId);

    Integer selectByAll(UserTable record);

    List<UserTable> selectByUserIdOrUserName(String param);

    List<UserTable> selectAll();

    Integer selectCount();

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);
}