package com.ssm.domain;

public class LendInfo {
    private Integer id;

    private String readerid;

    private Integer bookid;

    private String lenddate;

    private String backdate;

    private Double fine;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReaderid() {
        return readerid;
    }

    public void setReaderid(String readerid) {
        this.readerid = readerid == null ? null : readerid.trim();
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getLenddate() {
        return lenddate;
    }

    public void setLenddate(String lenddate) {
        this.lenddate = lenddate == null ? null : lenddate.trim();
    }

    public String getBackdate() {
        return backdate;
    }

    public void setBackdate(String backdate) {
        this.backdate = backdate == null ? null : backdate.trim();
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}