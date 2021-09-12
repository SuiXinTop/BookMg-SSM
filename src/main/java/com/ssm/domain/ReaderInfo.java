package com.ssm.domain;

public class ReaderInfo {
    private Integer id;

    private String readerid;

    private String name;

    private String password;

    private String sex;

    private String birthday;

    private String address;

    private String telephone;

    private Integer cardstate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getCardstate() {
        return cardstate;
    }

    public void setCardstate(Integer cardstate) {
        this.cardstate = cardstate;
    }
}