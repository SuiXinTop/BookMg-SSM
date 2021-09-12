package com.ssm.dao;

import com.ssm.domain.AdminInfo;

import java.util.List;

public interface AdminInfoMapper {
    int deleteByPrimaryKey(String admid);

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    List<AdminInfo> selectAll();

    AdminInfo selectByPrimaryKey(String admid);

    int updateByPrimaryKeySelective(AdminInfo record);

    int updateByPrimaryKey(AdminInfo record);
}