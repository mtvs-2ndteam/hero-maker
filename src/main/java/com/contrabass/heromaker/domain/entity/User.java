package com.contrabass.heromaker.domain.entity;

public class User {
    private final int userNo;
    private final String id;
    private final String pw;
    private final String name;
    private final String phone;
    private final String email;

    public User(int userNo, String id, String pw, String name, String phone, String email) {
        this.userNo = userNo;
        this.id = id;
        this.pw = pw;
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

    public String getPw() {
        return pw;
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
