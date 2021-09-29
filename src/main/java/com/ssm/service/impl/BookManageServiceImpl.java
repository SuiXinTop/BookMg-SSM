package com.ssm.service.impl;

import com.ssm.dao.BookInfoMapper;
import com.ssm.dao.BookManageMapper;
import com.ssm.domain.BookManage;
import com.ssm.service.BookManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Service("bookManageService")
public class BookManageServiceImpl implements BookManageService {
    private final BookInfoMapper bookInfoMapper;
    private final BookManageMapper bookManageMapper;

    public BookManageServiceImpl(BookInfoMapper bookInfoMapper, BookManageMapper bookManageMapper) {
        this.bookInfoMapper = bookInfoMapper;
        this.bookManageMapper = bookManageMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object select() {

        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int selectCountByUserId(int userId) {
        return bookManageMapper.selectCountByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object selectByUserId(int userId) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object selectByBookId() {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<HashMap<Object,Object>> selectByParam(String param) {
        return bookManageMapper.selectByParam(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int borrowOn(int bookId, int userId) {
        int limit = 3;
        BookManage bookManage = new BookManage(bookId, userId, "借阅申请中");
        //查询该用户正在借阅数量不多于三本
        if (bookManageMapper.selectCountByUserId(userId) >= limit) {
            throw new RuntimeException();
        }
        //插入一条预备借阅记录 bookTf为 申请中
        bookManageMapper.insert(bookManage);
        //书的数量-1
        if (bookInfoMapper.updateDecByPrimaryKey(bookId) == 0) {
            throw new RuntimeException();
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object borrowOff(int id, int bookId) {
        //根据id修改状态为已取消
        BookManage bookManage = new BookManage(id, "已取消");
        bookManageMapper.updateByPrimaryKey(bookManage);
        //书的数量+1
        bookInfoMapper.updatePlusByPrimaryKey(bookId);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object borrowSuccess(int id) {
        //根据id修改bookTf为借阅中
        BookManage bookManage = new BookManage(id, "借阅中");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object borrowFailure(int id, int bookId) {
        //根据id修改bookTf为未通过
        //booId库存+1
        BookManage bookManage = new BookManage(id, "借阅未通过");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        if (bookInfoMapper.updatePlusByPrimaryKey(bookId) == 0) {
            throw new RuntimeException();
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object returnOn(int id) {
        //根据id修改bookTf为归还申请中
        BookManage bookManage = new BookManage(id, "归还申请中");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object returnOff(int id) {
        //根据id修改bookTf为借阅中
        BookManage bookManage = new BookManage(id, "借阅中");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object returnSuccess(int id, int bookId) {
        //根据id修改bookTf为已归还
        BookManage bookManage = new BookManage(id, "已归还");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        //图书库存+1
        if (bookInfoMapper.updatePlusByPrimaryKey(bookId) == 0) {
            throw new RuntimeException();
        }
        return 1;
    }
}
