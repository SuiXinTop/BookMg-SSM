package com.ssm.controller;

import com.ssm.domain.UserTable;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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
        return userTable.getUserId();
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
     * @param file MultipartFile
     * @param path  String
     * @return Object
     */
    @RequestMapping(value = "/addImg", method = RequestMethod.POST)
    @ResponseBody
    public Object addTitleImg(@RequestParam(value = "file") MultipartFile file,
                              @RequestParam(value = "path") String path) {
        String filePath = path + "/head.jpg";
        File targetFile = new File("E:/SourcesServer" + filePath);
        if (!file.isEmpty()) {
            try {
                file.transferTo(targetFile);
                return "http://localhost:8090" + filePath;
            } catch (IOException e) {
                return "存储失败";
            }
        }
        return 0;
    }

    /**
     * 需改用户信息
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
    @RequestMapping(value = "/user/selectByUserId", method = RequestMethod.POST)
    @ResponseBody
    public Object selectByUserId(String param) {
        return 0;
    }//TODO

    /**
     * 查询所有用户信息
     *
     * @return pageInfo
     */
    @RequestMapping(value = "/user/select", method = RequestMethod.POST)
    @ResponseBody
    public Object select() {
        return 0;
    }//TODO

    /**
     * 统计用户数量
     *
     * @return int
     */
    @RequestMapping(value = "/user/count", method = RequestMethod.GET)
    @ResponseBody
    public int selectCount() {
        return 0;
    }//TODO

}
