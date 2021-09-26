package com.ssm.domain;

import java.io.Serializable;

/**
 * @author STARS
 */
public class AdminTable implements Serializable {
    private String admId;

    private String admPassword;

    public AdminTable() {
    }

    public AdminTable(String admId, String admPassword) {
        this.admId = admId;
        this.admPassword = admPassword;
    }

    public String getAdmId() {
        return admId;
    }

    public void setAdmId(String admId) {
        this.admId = admId == null ? null : admId.trim();
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword == null ? null : admPassword.trim();
    }

    @Override
    public String toString() {
        return "AdminTable{" +
                "admId='" + admId + '\'' +
                ", admPassword='" + admPassword + '\'' +
                '}';
    }
}