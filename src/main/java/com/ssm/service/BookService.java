package com.ssm.service;

import com.ssm.domain.BookInfo;

import java.util.List;

public interface BookService {
    int addBook(BookInfo bookInfo);

    int updateBook(BookInfo bookInfo);

    int delBook(int bookId);

    BookInfo selectByPrimaryKey(Integer bookId);

    List<BookInfo> selectBy(Object param);
}
