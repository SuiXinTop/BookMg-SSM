package com.ssm.service;

import com.ssm.domain.AdminTable;

public interface AdminService {
    /**管理员登陆
     *
     * @param adminTable a
     * @return i
     */
    Integer adminLogin(AdminTable adminTable);
}
