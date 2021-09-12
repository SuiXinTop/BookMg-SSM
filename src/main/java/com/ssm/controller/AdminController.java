package com.ssm.controller;

import com.ssm.domain.AdminInfo;
import com.ssm.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author xxx
 * @create 2021-09-11
 */
@Controller
@RequestMapping("/user")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @RequestMapping("/tologin")
    public String toLogin() {
        return "index";
    }

    @RequestMapping("/selectAll")
    public String selectAll(Model model) {
        List<AdminInfo> list = adminService.selectAll();
        model.addAttribute("list", list);
        return "all";
    }
}
