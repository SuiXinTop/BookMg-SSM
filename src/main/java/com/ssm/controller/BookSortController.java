package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.domain.BookSort;
import com.ssm.service.BookSortService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Controller
@RequestMapping("/bookSort")
public class BookSortController {
    private final BookSortService bookSortService;

    public BookSortController(BookSortService bookSortService) {
        this.bookSortService = bookSortService;
    }

    /**
     * 书类添加
     *
     * @param bookSort bookSort
     * @return status
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addSort(@RequestBody BookSort bookSort) {
        int t = bookSortService.addSort(bookSort);
        return t != 0;
    }

    /**
     * 书类更新
     *
     * @param bookSort bookSort
     * @return status
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateSort(@RequestBody BookSort bookSort) {
        int t = bookSortService.updateSort(bookSort);
        return t != 0;
    }

    /**
     * 书类删除
     *
     * @param bookSort bookId
     * @return status
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delSort(@RequestBody BookSort bookSort) {
        int t = bookSortService.delSort(bookSort.getSortId());
        return t != 0;
    }

    /**按书名查询ID
     *
     * @param sortName
     * @return
     */
    @RequestMapping(value = "/selectIdByName", method = RequestMethod.GET)
    @ResponseBody
    public int selectIdByName(@RequestParam("sortName") String sortName) {
        return 0;
    }//TODO

    /**
     * 书类全览
     *
     * @param pageNum  pageNum
     * @param pageSize pageSize
     * @return PageInfo
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<BookSort> select(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BookSort> list = bookSortService.selectAll();
        return new PageInfo<>(list, pageSize);
    }

    /**
     * 书类总数
     *
     * @return int
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public int selectCount() {
        return 0;
    }//TODO

}
