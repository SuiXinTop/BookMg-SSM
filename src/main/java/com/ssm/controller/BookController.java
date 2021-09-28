package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.domain.BookInfo;
import com.ssm.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 图书添加
     *
     * @param bookInfo bookInfo
     * @return status
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addBook(@RequestBody BookInfo bookInfo) {
        try {
            return bookService.addBook(bookInfo);
        } catch (Exception e) {
            return 0;
        }

    }

    /**图片存储
     *
     * @param files MultipartFile
     * @param path String
     * @return Object
     */
    @RequestMapping(value = "/addImg", method = RequestMethod.POST)
    @ResponseBody
    public Object addTitleImg(@RequestParam(value = "file") MultipartFile[] files,
                              @RequestParam(value = "path") String path) {
        List<String> list = new ArrayList<>();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String filePath = path + "/" + i + ".jpg";
                File targetFile = new File("E:/SourcesServer" + filePath);
                if (!file.isEmpty()) {
                    try {
                        file.transferTo(targetFile);
                        list.add("http://localhost:8090" + filePath);
                    } catch (IOException e) {
                        return "存储第" + i + "张失败";
                    }
                }
            }
            return list;
        }
        return 0;
    }

    /**
     * 图书更新
     *
     * @param bookInfo bookInfo
     * @return status
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateBook(@RequestBody BookInfo bookInfo) {
        int t = bookService.updateBook(bookInfo);
        return t != 0;
    }

    /**
     * 图书删除
     *
     * @param bookInfo bookId
     * @return status
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delBook(@RequestBody BookInfo bookInfo) {
        int t = bookService.delBook(bookInfo.getBookId());
        return t != 0;
    }

    /**
     * 按Id查询
     *
     * @param bookId bookId
     * @return BookInfo
     */
    @RequestMapping(value = "/selectByBookId", method = RequestMethod.GET)
    @ResponseBody
    public Object selectByBookId(@RequestParam("bookId") int bookId) {
        return bookService.selectByPrimaryKey(bookId);
    }

    /**
     * 分页全局条件查询
     *
     * @param param    param
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return PageInfo
     */
    @RequestMapping(value = "/selectBy", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<BookInfo> selectBy(@RequestParam(value = "param", defaultValue = "") String param,
                                       @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BookInfo> list = bookService.selectBy(param);
        return new PageInfo<>(list, pageSize);
    }//TODO
}
