package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class Categorys implements Serializable {
    private int theloaiId;
    private String tentheloai;

    public Categorys(int theloaiId, String tentheloai) {
        this.theloaiId = theloaiId;
        this.tentheloai = tentheloai;
    }

    public Categorys(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public int getTheloaiID() {
        return theloaiId;
    }

    public void setTheloaiID(int theloaiId) {
        this.theloaiId = theloaiId;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }
}
