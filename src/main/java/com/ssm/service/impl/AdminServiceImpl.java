package com.ssm.service.impl;

import com.ssm.dao.AdminTableMapper;
import com.ssm.domain.AdminTable;
import com.ssm.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @author xxx
 * @create 2021-09-25
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    private final AdminTableMapper adminTableMapper;

    public AdminServiceImpl(AdminTableMapper adminTableMapper) {
        this.adminTableMapper = adminTableMapper;
    }
    @Override
    public Integer adminLogin(AdminTable adminTable){
        return adminTableMapper.selectByAll(adminTable);
    }
}
