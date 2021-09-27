package com.ssm.dao;

import com.ssm.domain.BookManage;

/**
 * @author STARS
 */
public interface BookManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookManage record);

    int insertSelective(BookManage record);

    BookManage selectByPrimaryKey(Integer id);

    Integer selectCountByUserId(Integer userId);

    int updateByPrimaryKeySelective(BookManage record);

    int updateByPrimaryKey(BookManage record);

}