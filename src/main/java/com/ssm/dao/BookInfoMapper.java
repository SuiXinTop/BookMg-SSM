package com.ssm.dao;

import com.ssm.domain.BookInfo;

import java.util.List;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKeyWithBLOBs(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}