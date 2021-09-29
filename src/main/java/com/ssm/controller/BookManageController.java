package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.service.BookManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 查询用户借阅的数量
     *
     * @param userId int
     * @return int
     */
    @RequestMapping(value = "/selectCountByUserId",method = RequestMethod.POST)
    @ResponseBody
    public int selectCountByUserId(@RequestHeader("authorization") int userId) {
        return bookManageService.selectCountByUserId(userId);
    }

    /**
     * 查询个人所有记录
     *
     * @param userId int
     * @return Object
     */
    @RequestMapping(value = "/selectByUserId",method = RequestMethod.POST)
    @ResponseBody
    public Object selectByUserId(@RequestHeader("authorization") int userId) {
        return bookManageService.selectByUserId(userId);
    }

    /**
     * 记录查找
     *
     * @param param String
     * @return PageInfo
     */
    @RequestMapping(value = "/selectByParam",method = RequestMethod.GET)
    @ResponseBody
    public Object selectByParam(@RequestParam(value = "param",defaultValue = "") String param,
                                @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(bookManageService.selectByParam(param), pageSize);
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
    public Object borrowOn(int bookId,@RequestHeader("authorization") int userId) {
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
    @RequestMapping(value = "/borrowOff", method = RequestMethod.POST)
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
    @RequestMapping(value = "/borrowSuccess", method = RequestMethod.POST)
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
    @RequestMapping(value = "/borrowFailure", method = RequestMethod.POST)
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
    @RequestMapping(value = "/returnOn", method = RequestMethod.POST)
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
    @RequestMapping(value = "/returnOff", method = RequestMethod.POST)
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
    @RequestMapping(value = "/returnSuccess", method = RequestMethod.POST)
    @ResponseBody
    public Object returnSuccess(int id, int bookId) {
        //前端判定该书在归还申请中
        try {
            return bookManageService.returnSuccess(id, bookId);
        } catch (Exception e) {
            return 0;
        }
    }
}
