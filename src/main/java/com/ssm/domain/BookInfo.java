package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author STARS
 */
public class BookInfo implements Serializable {
    private Integer bookId;

    private String bookIsbn;

    private String bookName;

    private String bookAuthor;

    private String bookPub;

    private Integer bookStock;

    private Integer bookSort;

    private Date bookRecord;

    private String bookDescribe;

    public BookInfo() {
    }

    public BookInfo(Integer bookId, String bookIsbn, String bookName, String bookAuthor, String bookPub, Integer bookStock, Integer bookSort, Date bookRecord, String bookDescribe) {
        this.bookId = bookId;
        this.bookIsbn = bookIsbn;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPub = bookPub;
        this.bookStock = bookStock;
        this.bookSort = bookSort;
        this.bookRecord = bookRecord;
        this.bookDescribe = bookDescribe;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn == null ? null : bookIsbn.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public String getBookPub() {
        return bookPub;
    }

    public void setBookPub(String bookPub) {
        this.bookPub = bookPub == null ? null : bookPub.trim();
    }

    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    public Integer getBookSort() {
        return bookSort;
    }

    public void setBookSort(Integer bookSort) {
        this.bookSort = bookSort;
    }

    public Date getBookRecord() {
        return bookRecord;
    }

    public void setBookRecord(Date bookRecord) {
        this.bookRecord = bookRecord;
    }

    public String getBookDescribe() {
        return bookDescribe;
    }

    public void setBookDescribe(String bookDescribe) {
        this.bookDescribe = bookDescribe == null ? null : bookDescribe.trim();
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookId=" + bookId +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPub='" + bookPub + '\'' +
                ", bookStock=" + bookStock +
                ", bookSort=" + bookSort +
                ", bookRecord=" + bookRecord +
                ", bookDescribe='" + bookDescribe + '\'' +
                '}';
    }
}