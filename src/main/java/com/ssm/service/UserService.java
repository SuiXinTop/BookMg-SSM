package com.ssm.service;

import com.ssm.domain.UserTable;

import java.util.List;

/**
 * @author STARS
 */
public interface UserService {
    Integer login(UserTable userTable);

    Integer register(UserTable userTable);

    Integer userNameVery(String userName);

    UserTable selectInfo(Integer userId);

    Integer selectCount();

    List<UserTable> selectAll();

    List<UserTable> selectByUserIdOrUserName(String param);

    Integer updateInfo(UserTable userTable);

    Integer updatePassword(UserTable userTable);
}
