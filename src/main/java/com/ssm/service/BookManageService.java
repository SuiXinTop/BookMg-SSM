package com.ssm.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author STARS
 */
public interface BookManageService {
    Object select();

    int selectCountByUserId(int userId);

    Object selectByUserId(int userId);

    Object selectByBookId();

    List<HashMap<Object,Object>> selectByParam(String param);

    int borrowOn(int bookId, int userId);

    Object borrowOff(int id, int bookId);

    Object borrowSuccess(int id);

    Object borrowFailure(int id, int bookId);

    Object returnOn(int id);

    Object returnOff(int id);

    Object returnSuccess(int id, int bookId);
}
