package com.ssm.service;

import com.ssm.domain.UserTable;

/**
 * @author STARS
 */
public interface UserService {
    public Integer login(UserTable userTable);
    public Integer register(UserTable userTable);
}