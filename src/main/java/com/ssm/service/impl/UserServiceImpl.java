package com.ssm.service.impl;

import com.ssm.dao.UserTableMapper;
import com.ssm.domain.UserTable;
import com.ssm.service.UserService;
import com.ssm.util.SecurityUtil;
import org.springframework.stereotype.Service;

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
    public Integer login(UserTable userTable){
        userTable.setUserPassword(SecurityUtil.getMd5(userTable.getUserPassword()));
        return userTableMapper.selectByAll(userTable);
    }

    @Override
    public Integer register(UserTable userTable){
        userTable.setUserPassword(SecurityUtil.getMd5(userTable.getUserPassword()));
        return userTableMapper.insert(userTable);
    }
}
