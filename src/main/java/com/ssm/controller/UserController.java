package com.ssm.controller;

import com.ssm.domain.UserTable;
import com.ssm.service.UserService;
import com.ssm.service.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    private final UtilService utilService;
    public UserController(UserService userService,UtilService utilService) {
        this.userService = userService;
        this.utilService=utilService;
    }

    /**
     * 用户登录
     *
     * @param userTable userTable
     * @return status
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody UserTable userTable) {
        int t = userService.login(userTable);
        if (t == 0) {
            return false;
        }
        return userTable.getUserName();
    }

    /**
     * 用户注册
     *
     * @param userTable userTable
     * @return status
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody UserTable userTable) {
        int t = userService.register(userTable);
        if (t == 0) {
            return false;
        }
        return userTable.getUserId();
    }

    /**
     * 图片存储
     *
     * @param files MultipartFile
     * @param path  String
     * @return Object
     */
    @RequestMapping(value = "/user/addImg", method = RequestMethod.POST)
    @ResponseBody
    public Object addTitleImg(@RequestParam(value = "file") MultipartFile[] files,
                              @RequestParam(value = "path") String path) {
        return utilService.addImg(files,path);
    }

    /**
     * 修改用户信息
     *
     * @param userTable userTable
     * @return status
     */
    @RequestMapping(value = "/user/updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateInfo(@RequestBody UserTable userTable) {
        int t = userService.updateInfo(userTable);
        return t != 0;
    }

    /**
     * 修改用户密码
     *
     * @param userTable userTable
     * @return status
     */
    @RequestMapping(value = "/user/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Object updatePassword(@RequestBody UserTable userTable) {
        int t = userService.updatePassword(userTable);
        return t != 0;
    }

    /**
     * 查询用户信息By UserId || UserName
     *
     * @return pageInfo
     */
    @RequestMapping(value = "/user/selectByIdOrName", method = RequestMethod.POST)
    @ResponseBody
    public Object selectByUserIdOrUserName(@RequestHeader("authorization") String param) {
        return userService.selectByUserIdOrUserName(param);
    }
    /**查询用户名是否被使用
     *
     */
    @RequestMapping(value = "/user/userNameVery", method = RequestMethod.POST)
    @ResponseBody
    public Integer userNameVery(String userName) {
        return userService.userNameVery(userName);
    }

    /**
     * 查询所有用户信息
     *
     * @return pageInfo
     */
    @RequestMapping(value = "/user/selectAll", method = RequestMethod.POST)
    @ResponseBody
    public Object selectAll() {
        return userService.selectAll();
    }

    /**
     * 统计用户数量
     *
     * @return int
     */
    @RequestMapping(value = "/user/count", method = RequestMethod.GET)
    @ResponseBody
    public int selectCount() {
        return userService.selectCount();
    }

}
