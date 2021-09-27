package com.ssm.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author STARS
 */
public class BookManage implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer bookId;

    private Date borrDate;

    private Date facDate;

    private Date excDate;

    private String bookTf;

    public BookManage() {
    }

    public BookManage( Integer bookId, Integer userId, String bookTf) {
        this.userId = userId;
        this.bookId = bookId;
        this.bookTf = bookTf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getBorrDate() {
        return borrDate;
    }

    public void setBorrDate(Date borrDate) {
        this.borrDate = borrDate;
    }

    public Date getFacDate() {
        return facDate;
    }

    public void setFacDate(Date facDate) {
        this.facDate = facDate;
    }

    public Date getExcDate() {
        return excDate;
    }

    public void setExcDate(Date excDate) {
        this.excDate = excDate;
    }

    public String getBookTf() {
        return bookTf;
    }

    public void setBookTf(String bookTf) {
        this.bookTf = bookTf == null ? null : bookTf.trim();
    }

    @Override
    public String toString() {
        return "BookManage{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", borrDate=" + borrDate +
                ", facDate=" + facDate +
                ", excDate=" + excDate +
                ", bookTf='" + bookTf + '\'' +
                '}';
    }
}