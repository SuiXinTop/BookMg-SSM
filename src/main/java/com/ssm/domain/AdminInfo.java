package com.ssm.domain;

public class AdminInfo {
    private String admid;

    private String admpassword;

    public String getAdmid() {
        return admid;
    }

    public void setAdmid(String admid) {
        this.admid = admid == null ? null : admid.trim();
    }

    public String getAdmpassword() {
        return admpassword;
    }

    public void setAdmpassword(String admpassword) {
        this.admpassword = admpassword == null ? null : admpassword.trim();
    }
}