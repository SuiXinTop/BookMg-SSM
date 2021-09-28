package com.ssm.service;

/**
 * @author STARS
 */
public interface BookManageService {
    public Object select();

    public int selectCountByUserId(int userId);

    public Object selectByUserId(int userId);

    public Object selectByBookId();

    public int borrowOn(int bookId, int userId);

    public Object borrowOff(int id, int bookId);

    public Object borrowSuccess(int id);

    public Object borrowFailure(int id, int bookId);

    public Object returnOn(int id);

    public Object returnOff(int id);

    public Object returnSuccess(int id, int bookId);
}
