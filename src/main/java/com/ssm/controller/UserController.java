package com.ssm.controller;

import com.ssm.dao.UserTableMapper;
import com.ssm.domain.UserTable;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody UserTable userTable){
      int t= userService.login(userTable);
      if(t==0){
          return false;
      }
      return userTable.getUserId();
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public  Object register(@RequestBody UserTable userTable){
        int t=userService.register(userTable);
        if(t==0){
            return false;
        }
        return userTable.getUserId();
    }
}
