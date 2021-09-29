package com.ssm.dao;

import com.ssm.domain.BookManage;

import java.util.HashMap;
import java.util.List;

/**
 * @author STARS
 */
public interface BookManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookManage record);

    int insertSelective(BookManage record);

    BookManage selectByPrimaryKey(Integer id);

    Integer selectCountByUserId(Integer userId);

    List<HashMap<Object,Object>> selectByParam(String param);

    int updateByPrimaryKeySelective(BookManage record);

    int updateByPrimaryKey(BookManage record);

}