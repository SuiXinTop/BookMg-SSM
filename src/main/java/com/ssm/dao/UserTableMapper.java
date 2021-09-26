package com.ssm.dao;

import com.ssm.domain.UserTable;

/**
 * @author STARS
 */
public interface UserTableMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    UserTable selectByPrimaryKey(Integer userId);

    Integer selectByAll(UserTable record);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);
}