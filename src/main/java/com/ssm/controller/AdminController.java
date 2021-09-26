package com.ssm.controller;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.ssm.domain.AdminTable;
import com.ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author xxx
 * @create 2021-09-25
 */
@Controller
@RequestMapping("/")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**管理员登录
     *
     * @param adminTable adminTable
     * @return object
     */
    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    @ResponseBody
    public Object adminLogin(@RequestBody AdminTable adminTable){
        Integer t= adminService.adminLogin(adminTable);
        if(t==0){
            return false;
        }
        return adminTable;
    }
}
