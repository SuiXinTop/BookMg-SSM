package com.ssm.dao;

import com.ssm.domain.BookSort;

public interface BookSortMapper {
    int deleteByPrimaryKey(Integer sortId);

    int insert(BookSort record);

    int insertSelective(BookSort record);

    BookSort selectByPrimaryKey(Integer sortId);

    int updateByPrimaryKeySelective(BookSort record);

    int updateByPrimaryKeyWithBLOBs(BookSort record);

    int updateByPrimaryKey(BookSort record);
}