package com.ssm.service;

import com.ssm.domain.UserTable;

/**
 * @author STARS
 */
public interface UserService {
    Integer login(UserTable userTable);

    Integer register(UserTable userTable);

    UserTable selectInfo(Integer userId);

    Integer updateInfo(UserTable userTable);

    Integer updatePassword(UserTable userTable);
}
