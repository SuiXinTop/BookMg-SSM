package com.ssm.dao;

import com.ssm.domain.BookInfo;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookid);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bookid);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}