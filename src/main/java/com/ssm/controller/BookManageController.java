package com.ssm.controller;

import com.ssm.service.BookManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Controller
@RequestMapping("/bookManage")
public class BookManageController {
    private final BookManageService bookManageService;
    public BookManageController(BookManageService bookManageService){
        this.bookManageService=bookManageService;
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    @RequestMapping(value = "/select")
    @ResponseBody
    public Object select() {
        // return mapper;
        return null;
    }

    /**查询用户借阅的数量
     *
     * @return
     */
    @RequestMapping(value = "/selectCountByUserId")
    @ResponseBody
    public Object selectCountByUserId(int userId) {
        // return mapper;
        return null;
    }
    /**
     * 查询个人所有记录
     *
     * @return
     */
    @RequestMapping(value = "/selectByUserId")
    @ResponseBody
    public Object selectByUserId(int userId) {
        // return mapper;
        return null;
    }

    /**
     * 查询某本书的所有记录
     *
     * @return
     */
    @RequestMapping(value = "/selectByBookId")
    @ResponseBody
    public Object selectByBookId() {
        // return mapper;
        return null;
    }

    /**发起借阅请求
     *
     * @param bookId
     * @param userId
     * @return
     */

    @RequestMapping(value = "/borrowOn",method = RequestMethod.POST)
    @ResponseBody
    public Object borrowOn(int bookId, int userId) {
            try {
                //前端判定书的数量
                return bookManageService.borrowOn(bookId,userId);
            }catch (Exception e){
                return 0;
            }
    }

    /**
     * 取消借阅请求
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/borrowOff")
    @ResponseBody
    public Object borrowOff(int id) {
        //前端判定该书在申请中
        //根据id修改状态为已取消
        //书的数量+1
        return true;
    }

    /**
     * 同意借阅请求
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/borrowSuccess")
    @ResponseBody
    public Object borrowSuccess(int id) {
        //前端判定该书在申请中
        //根据id修改bookTf为借阅中
        return true;
    }

    /**
     * 拒绝借阅请求
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/borrowFailure")
    @ResponseBody
    public Object borrowFailure(int id) {
        //前端判定该书在申请中
        //根据id修改bookTf为未通过
        return true;
    }

    /**
     * 发起归还请求
     */
    @RequestMapping(value = "/returnOn")
    @ResponseBody
    public Object returnOn(int id) {
        //前端判定该书在借阅中
        //根据id修改bookTf为归还申请中
        return true;
    }

    /**
     * 取消归还请求
     */
    @RequestMapping(value = "/returnOff")
    @ResponseBody
    public Object returnOff(int id) {
        //前端判定该书在归还申请中
        //根据id修改bookTf为借阅中
        return true;
    }

    /**
     * 同意归还请求
     */
    @RequestMapping(value = "/returnSuccess")
    @ResponseBody
    public Object returnSuccess(int id) {
        //前端判定该书在归还申请中
        //根据id修改bookTf为已归还
        //图书库存+1
        return true;
    }
}//todo
