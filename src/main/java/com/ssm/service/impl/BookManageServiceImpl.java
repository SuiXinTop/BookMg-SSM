package com.ssm.service.impl;

import com.ssm.dao.BookInfoMapper;
import com.ssm.dao.BookManageMapper;
import com.ssm.domain.BookManage;
import com.ssm.service.BookManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Service("bookManageService")
public class BookManageServiceImpl implements BookManageService {
    private final BookInfoMapper bookInfoMapper;
    private final BookManageMapper bookManageMapper;
    public BookManageServiceImpl(BookInfoMapper bookInfoMapper,BookManageMapper bookManageMapper){
        this.bookInfoMapper=bookInfoMapper;
        this.bookManageMapper=bookManageMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int borrowOn(int bookId, int userId){
        BookManage bookManage=new BookManage(bookId,userId,"借阅申请中");
        //查询该用户借阅数量不多于三本
        if (bookManageMapper.selectCountByUserId(userId)>=3){
            throw new RuntimeException();
        }
        //插入一条预备借阅记录 bookTf为 申请中
        bookManageMapper.insert(bookManage);
        //书的数量-1
        if(bookInfoMapper.updateDecByPrimaryKey(bookId)==0){
            throw new RuntimeException();
        }
        return 1;
    }
}
