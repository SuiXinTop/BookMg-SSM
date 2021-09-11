package com.ssm.dao;

import com.ssm.domain.ClassInfo;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}