package com.contrabass.heromaker.domain.entity;

public class User {
    private final int userNo;
    private final String id;
    private final String pwd;
    private final String name;
    private final String phone;
    private final String email;

    public User(int userNo, String id, String pwd, String name, String phone, String email) {
        this.userNo = userNo;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getUserNo() {
        return userNo;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
