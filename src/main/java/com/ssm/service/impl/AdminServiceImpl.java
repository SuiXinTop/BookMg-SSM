package com.ssm.service.impl;

import com.ssm.dao.AdminInfoMapper;
import com.ssm.domain.AdminInfo;
import com.ssm.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxx
 * @create 2021-09-12
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    private final AdminInfoMapper adminInfoMapper;
    public AdminServiceImpl(AdminInfoMapper adminInfoMapper) {
        this.adminInfoMapper = adminInfoMapper;
    }

    @Override
    public List<AdminInfo> selectAll(){
        return adminInfoMapper.selectAll();
    }
}
