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

    public BookManageController(BookManageService bookManageService) {
        this.bookManageService = bookManageService;
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
     * @param userId
     * @return
     */

    @RequestMapping(value = "/selectCountByUserId")
    @ResponseBody
    public int selectCountByUserId(int userId) {
        return bookManageService.selectCountByUserId(userId);
    }

    /**查询个人所有记录
     *
     * @param userId
     * @return
     */

    @RequestMapping(value = "/selectByUserId")
    @ResponseBody
    public Object selectByUserId(int userId) {
        bookManageService.selectByUserId(userId);
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

    /**
     * 发起借阅请求
     *
     * @param bookId bookId
     * @param userId userId
     * @return int
     */


    @RequestMapping(value = "/borrowOn", method = RequestMethod.POST)
    @ResponseBody
    public Object borrowOn(int bookId, int userId) {
        try {
            //前端判定书的数量
            return bookManageService.borrowOn(bookId, userId);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 取消借阅请求
     *
     * @param id     id
     * @param bookId bookId
     * @return int
     */

    @RequestMapping(value = "/borrowOff")
    @ResponseBody
    public Object borrowOff(int id, int bookId) {
        //前端判定该书在申请中
        try {
            return bookManageService.borrowOff(id, bookId);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 同意借阅请求
     *
     * @param id id
     * @return int
     */
    @RequestMapping(value = "/borrowSuccess")
    @ResponseBody
    public Object borrowSuccess(int id) {
        //前端判定该书在申请中
//        try {
            return bookManageService.borrowSuccess(id);
//        } catch (Exception e) {
//            return 0;
//        }
    }

    /**
     * 拒绝借阅请求
     *
     * @param id     id
     * @param bookId bookId
     * @return int
     */
    @RequestMapping(value = "/borrowFailure")
    @ResponseBody
    public Object borrowFailure(int id, int bookId) {
        //前端判定该书在申请中
        try {
            return bookManageService.borrowFailure(id, bookId);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 发起归还请求
     *
     * @param id id
     * @return int
     */

    @RequestMapping(value = "/returnOn")
    @ResponseBody
    public Object returnOn(int id) {
        //前端判定该书在借阅中
        try {
            return bookManageService.returnOn(id);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 取消归还请求
     *
     * @param id id
     * @return int
     */

    @RequestMapping(value = "/returnOff")
    @ResponseBody
    public Object returnOff(int id) {
        //前端判定该书在归还申请中
        try {
            return bookManageService.returnOff(id);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 同意归还请求
     *
     * @param id     id
     * @param bookId bookId
     * @return int
     */
    @RequestMapping(value = "/returnSuccess")
    @ResponseBody
    public Object returnSuccess(int id, int bookId) {
        //前端判定该书在归还申请中
//        try {
            return bookManageService.returnSuccess(id, bookId);
//        } catch (Exception e) {
//            return 0;
//        }
    }
}//todo
