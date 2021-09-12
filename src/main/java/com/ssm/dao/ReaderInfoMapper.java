package com.ssm.dao;

import com.ssm.domain.ReaderInfo;

public interface ReaderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReaderInfo record);

    int insertSelective(ReaderInfo record);

    ReaderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReaderInfo record);

    int updateByPrimaryKey(ReaderInfo record);
}