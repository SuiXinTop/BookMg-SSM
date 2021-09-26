package com.ssm.dao;

import com.ssm.domain.AdminTable;

/**
 * @author STARS
 */
public interface AdminTableMapper {
    int deleteByPrimaryKey(String admId);

    int insert(AdminTable record);

    int insertSelective(AdminTable record);

    AdminTable selectByPrimaryKey(String admId);

    Integer selectByAll(AdminTable record);

    int updateByPrimaryKeySelective(AdminTable record);

    int updateByPrimaryKey(AdminTable record);
}