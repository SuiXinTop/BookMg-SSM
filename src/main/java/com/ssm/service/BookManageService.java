package com.ssm.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author STARS
 */
public interface BookManageService {

    int selectCountByUserName(String userName);

    Object selectByUserName(String userName,String status,int pageNum,int pageSize);

    List<HashMap<Object,Object>> selectByParam(String param);

    int borrowOn(int bookId, String userName);

    Object borrowOff(int id, int bookId);

    Object borrowSuccess(int id);

    Object borrowFailure(int id, int bookId);

    Object returnOn(int id);

    Object returnOff(int id);

    Object returnSuccess(int id, int bookId);
}
