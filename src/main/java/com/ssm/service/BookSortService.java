package com.ssm.service;

import com.ssm.domain.BookSort;

import java.util.List;

/**
 * @author STARS
 */
public interface BookSortService {
    public int addSort(BookSort bookSort);

    public int updateSort(BookSort bookSort);

    public int delSort(Integer sortId);

    public List<BookSort> selectAll();
}
