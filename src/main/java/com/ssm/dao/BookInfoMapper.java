package com.ssm.dao;

import com.ssm.domain.BookInfo;

import java.util.List;

/**
 * @author STARS
 */
public interface BookInfoMapper {
    /**主键删除
     *
     * @param bookId id
     * @return int
     */
    int deleteByPrimaryKey(Integer bookId);

    /**图书添加
     *
     * @param record BookInfo
     * @return int
     */
    int insert(BookInfo record);

    /**图书添加（null）
     *
     * @param record BookInfo
     * @return int
     */
    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bookId);

    List<BookInfo> selectBy(Object param);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKeyWithBLOBs(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}