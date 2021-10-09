package com.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.BookInfoMapper;
import com.ssm.domain.BookInfo;
import com.ssm.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
    @Transactional(rollbackFor = Exception.class)
    public int addBook(BookInfo bookInfo) {
        return bookInfoMapper.insert(bookInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateBook(BookInfo bookInfo) {
        return bookInfoMapper.updateByPrimaryKey(bookInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delBook(int bookId) {
        return bookInfoMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public BookInfo selectByPrimaryKey(Integer bookId) {
        return bookInfoMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public List<HashMap<Object,Object>> selectCountGroupBySort(){
        return bookInfoMapper.selectCountGroupBySort();
    }

    @Override
    public Object selectBy(int pageNum,int pageSize,Object param) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(bookInfoMapper.selectBy(param),pageSize) ;
    }
}
