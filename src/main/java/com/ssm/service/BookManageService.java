package com.ssm.service;

/**
 * @author STARS
 */
public interface BookManageService {
    Object select();

    int selectCountByUserId(int userId);

    Object selectByUserId(int userId);

    Object selectByBookId();

    int borrowOn(int bookId, int userId);

    Object borrowOff(int id, int bookId);

    Object borrowSuccess(int id);

    Object borrowFailure(int id, int bookId);

    Object returnOn(int id);

    Object returnOff(int id);

    Object returnSuccess(int id, int bookId);
}
