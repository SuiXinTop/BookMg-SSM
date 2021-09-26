package com.ssm.service.impl;

import com.ssm.dao.BookInfoMapper;
import com.ssm.domain.BookInfo;
import com.ssm.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    private final BookInfoMapper bookInfoMapper;

    public BookServiceImpl(BookInfoMapper bookInfoMapper) {
        this.bookInfoMapper = bookInfoMapper;
    }
    @Override
    public int addBook(BookInfo bookInfo){
        return bookInfoMapper.insert(bookInfo);
    }

    @Override
    public int updateBook(BookInfo bookInfo){
        return bookInfoMapper.updateByPrimaryKey(bookInfo);
    }

    @Override
    public int delBook(int bookId){
        return bookInfoMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public BookInfo selectByPrimaryKey(BookInfo bookInfo){
        return bookInfoMapper.selectByPrimaryKey(bookInfo.getBookId());
    }
}
