package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xxx
 * @create 2021-09-11
 */
@Controller
@RequestMapping("/i")
public class Navigtor {
    @RequestMapping("/tologin")
    public String ToLogin(){
        return "index";
    }
}
