package com.ssm.service.impl;

import com.ssm.dao.BookSortMapper;
import com.ssm.domain.BookSort;
import com.ssm.service.BookSortService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxx
 * @create 2021-09-26
 */
@Service("bookSortService")
public class BookSortServiceImpl implements BookSortService {
    private final BookSortMapper bookSortMapper;

    public BookSortServiceImpl(BookSortMapper bookSortMapper) {
        this.bookSortMapper = bookSortMapper;
    }

    @Override
    public int addSort(BookSort bookSort) {
        return bookSortMapper.insert(bookSort);
    }

    @Override
    public int updateSort(BookSort bookSort) {
        return bookSortMapper.updateByPrimaryKey(bookSort);
    }

    @Override
    public int delSort(Integer sortId) {
        return bookSortMapper.deleteByPrimaryKey(sortId);
    }

    @Override
    public List<BookSort> selectAll() {
        return bookSortMapper.selectAll();
    }

    @Override
    public int selectCount() {
        return bookSortMapper.selectCount();
    }

    @Override
    public int selectIdByName(String sortName){
        return bookSortMapper.selectIdByName(sortName);
    }
}
