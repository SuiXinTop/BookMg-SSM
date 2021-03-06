package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.BookInfoMapper;
import com.ssm.dao.BookManageMapper;
import com.ssm.dao.UserTableMapper;
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
    private final UserTableMapper userTableMapper;
    private final BookInfoMapper bookInfoMapper;
    private final BookManageMapper bookManageMapper;

    public BookManageServiceImpl(BookInfoMapper bookInfoMapper, BookManageMapper bookManageMapper, UserTableMapper userTableMapper) {
        this.userTableMapper = userTableMapper;
        this.bookInfoMapper = bookInfoMapper;
        this.bookManageMapper = bookManageMapper;
    }

    @Override
    public int selectCountByUserName(String userName) {
        int userId = userTableMapper.selectIdByName(userName);
        return bookManageMapper.selectCountByUserId(userId);
    }

    @Override
    public Object selectByUserName(String userName,String status,int pageNum,int pageSize) {
        int userId = userTableMapper.selectIdByName(userName);
        BookManage bookManage = new BookManage();
        bookManage.setUserId(userId);
        bookManage.setBookTf(status);

        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(bookManageMapper.selectByUserIdAndStatus(bookManage), pageSize);
    }

    @Override
    public List<HashMap<Object, Object>> selectByParam(String param) {
        return bookManageMapper.selectByParam(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int borrowOn(int bookId, String userName) {
        int userId = userTableMapper.selectIdByName(userName);
        int limit = 3;
        BookManage bookManage = new BookManage(bookId, userId, "???????????????");
        //????????????????????????????????????????????????
        if (bookManageMapper.selectCountByUserId(userId) >= limit) {
            throw new RuntimeException();
        }
        //?????????????????????????????? bookTf??? ?????????
        bookManageMapper.insert(bookManage);
        //????????????-1
        if (bookInfoMapper.updateDecByPrimaryKey(bookId) == 0) {
            throw new RuntimeException();
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object borrowOff(int id, int bookId) {
        //??????id????????????????????????
        BookManage bookManage = new BookManage(id, "?????????");
        bookManageMapper.updateByPrimaryKey(bookManage);
        //????????????+1
        bookInfoMapper.updatePlusByPrimaryKey(bookId);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object borrowSuccess(int id) {
        //??????id??????bookTf????????????
        BookManage bookManage = new BookManage(id, "?????????");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object borrowFailure(int id, int bookId) {
        //??????id??????bookTf????????????
        //booId??????+1
        BookManage bookManage = new BookManage(id, "???????????????");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        if (bookInfoMapper.updatePlusByPrimaryKey(bookId) == 0) {
            throw new RuntimeException();
        }
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object returnOn(int id) {
        //??????id??????bookTf??????????????????
        BookManage bookManage = new BookManage(id, "???????????????");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object returnOff(int id) {
        //??????id??????bookTf????????????
        BookManage bookManage = new BookManage(id, "?????????");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        return 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object returnSuccess(int id, int bookId) {
        //??????id??????bookTf????????????
        BookManage bookManage = new BookManage(id, "?????????");
        bookManageMapper.updateByPrimaryKeySelective(bookManage);
        //????????????+1
        if (bookInfoMapper.updatePlusByPrimaryKey(bookId) == 0) {
            throw new RuntimeException();
        }
        return 1;
    }
}
