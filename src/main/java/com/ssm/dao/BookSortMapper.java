package com.ssm.dao;

import com.ssm.domain.BookSort;

import java.util.List;

/**
 * @author STARS
 */
public interface BookSortMapper {
    int deleteByPrimaryKey(Integer sortId);

    int insert(BookSort record);

    int insertSelective(BookSort record);

    BookSort selectByPrimaryKey(Integer sortId);

    List<BookSort> selectAll();

    int updateByPrimaryKeySelective(BookSort record);

    int updateByPrimaryKeyWithBLOBs(BookSort record);

    int updateByPrimaryKey(BookSort record);
}