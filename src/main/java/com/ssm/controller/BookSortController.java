package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.domain.BookSort;
import com.ssm.service.BookSortService;
import com.ssm.service.UserService;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addSort(@RequestBody BookSort bookSort) {
//        return  bookSort;
        int t = bookSortService.addSort(bookSort);
        return t != 0;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object updateSort(@RequestBody BookSort bookSort) {
        int t = bookSortService.updateSort(bookSort);
        return t != 0;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delSort(@RequestBody BookSort bookSort) {
        int t = bookSortService.delSort(bookSort.getSortId());
        return t != 0;
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public Object select(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BookSort> list = bookSortService.selectAll();
        return new PageInfo<BookSort>(list,pageSize);
    }
}
