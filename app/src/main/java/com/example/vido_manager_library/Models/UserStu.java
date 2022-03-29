package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class UserStu implements Serializable {
    private int mssv;
    private  String name;
    private String password;

    public UserStu(int mssv, String name, String password) {
        this.mssv = mssv;
        this.name = name;
        this.password = password;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
