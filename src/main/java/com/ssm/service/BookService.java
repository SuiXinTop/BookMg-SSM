package com.ssm.service;

import com.ssm.domain.BookInfo;

public interface BookService {
    public int addBook(BookInfo bookInfo);

    public int updateBook(BookInfo bookInfo);

    public int delBook(int bookId);

    public BookInfo selectByPrimaryKey(BookInfo bookInfo);
}
