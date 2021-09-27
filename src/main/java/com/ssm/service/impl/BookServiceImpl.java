package com.ssm.service.impl;

import com.ssm.dao.BookInfoMapper;
import com.ssm.domain.BookInfo;
import com.ssm.service.BookService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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
    public int addBook(BookInfo bookInfo) {
        try {
            return bookInfoMapper.insert(bookInfo);
        } catch (DataAccessException e) {
           return 0;
        }
    }

    @Override
    public int updateBook(BookInfo bookInfo) {
        return bookInfoMapper.updateByPrimaryKey(bookInfo);
    }

    @Override
    public int delBook(int bookId) {
        return bookInfoMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public BookInfo selectByPrimaryKey(Integer bookId) {
        return bookInfoMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public List<BookInfo> selectBy(Object param){
        return bookInfoMapper.selectBy(param);
    }
}
