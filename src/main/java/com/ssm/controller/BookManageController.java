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
     * @param userName String
     * @return int
     */
    @RequestMapping(value = "/selectCountByUserName",method = RequestMethod.POST)
    @ResponseBody
    public int selectCountByUserId(@RequestHeader("authorization") String userName) {
        return bookManageService.selectCountByUserName(userName);
    }

    /**
     * 查询个人所有记录
     *
     * @param userName String
     * @return Object
     */
    @RequestMapping(value = "/selectByUserName",method = RequestMethod.POST)
    @ResponseBody
    public Object selectByUserId(@RequestHeader("authorization") String userName,
                                 int status,
                                 int pageNum,
                                 int pageSize) {
        String param;
        switch(status){
            case 0: param ="借阅已取消";break;
            case 1: param ="借阅未通过";break;
            case 2: param ="借阅审核中";break;
            case 3: param ="借阅中";break;
            case 4: param ="归还审核中";break;
            case 5: param ="已归还审核中";break;
            default: param="";break;
        }
        return bookManageService.selectByUserName(userName,param,pageNum,pageSize);

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
     * @param bookId int
     * @param userName Sting
     * @return int
     */
    @RequestMapping(value = "/borrowOn", method = RequestMethod.POST)
    @ResponseBody
    public Object borrowOn(int bookId,@RequestHeader("authorization") String userName) {
        try {
            //前端判定书的数量
            return bookManageService.borrowOn(bookId, userName);
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
