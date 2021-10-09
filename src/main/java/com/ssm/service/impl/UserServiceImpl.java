package com.ssm.service.impl;

import com.ssm.dao.UserTableMapper;
import com.ssm.domain.UserTable;
import com.ssm.service.UserService;
import com.ssm.util.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private final UserTableMapper userTableMapper;

    public UserServiceImpl(UserTableMapper userTableMapper) {
        this.userTableMapper = userTableMapper;
    }

    @Override
    public Integer login(UserTable userTable) {
        userTable.setUserPassword(SecurityUtil.getMd5(userTable.getUserPassword()));
        return userTableMapper.selectByAll(userTable);
    }

    @Override
    public Integer register(UserTable userTable) {
        userTable.setUserPassword(SecurityUtil.getMd5(userTable.getUserPassword()));
        return userTableMapper.insert(userTable);
    }

    @Override
    public Integer userNameVery(String userName){
        return userTableMapper.selectCountByName(userName);
    }


    @Override
    public UserTable selectInfo(Integer userId) {
        return userTableMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Integer selectCount(){
        return  userTableMapper.selectCount();
    }

    @Override
    public List<UserTable> selectAll(){
        return userTableMapper.selectAll();
    }

    @Override
    public List<UserTable> selectByUserIdOrUserName(String param){
        return userTableMapper.selectByUserIdOrUserName(param);
    }

    @Override
    public Integer updateInfo(UserTable userTable) {
        return userTableMapper.updateByPrimaryKeySelective(userTable);
    }

    @Override
    public Integer updatePassword(UserTable userTable) {
        userTable.setUserPassword(SecurityUtil.getMd5(userTable.getUserPassword()));
        return userTableMapper.updateByPrimaryKeySelective(userTable);
    }
}
