package com.ssm.service;

import com.ssm.domain.BookSort;

import java.util.List;

/**
 * @author STARS
 */
public interface BookSortService {
    int addSort(BookSort bookSort);

    int updateSort(BookSort bookSort);

    int delSort(Integer sortId);

    List<BookSort> selectAll();
}
