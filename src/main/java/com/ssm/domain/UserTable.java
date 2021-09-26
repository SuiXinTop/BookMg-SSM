package com.ssm.domain;

import java.io.Serializable;

/**
 * @author STARS
 */
public class UserTable implements Serializable {
    private Integer userId;

    private String userName;

    private String userSex;

    private Integer userAge;

    private String userPhone;

    private String userPassword;

    private String userStatus;

    public UserTable() {
    }

    public UserTable(Integer userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public UserTable(Integer userId, String userName, String userSex, Integer userAge, String userPhone, String userPassword, String userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    @Override
    public String toString() {
        return "UserTable{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userStatus='" + userStatus + '\'' +
                '}';
    }
}