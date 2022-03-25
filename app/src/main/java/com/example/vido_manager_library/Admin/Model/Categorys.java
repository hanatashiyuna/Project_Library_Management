package com.example.vido_manager_library.Admin.Model;

import java.io.Serializable;

public class Categorys implements Serializable {
    private int theloaiID;
    private String tentheloai;

    public Categorys(int theloaiID, String tentheloai) {
        this.theloaiID = theloaiID;
        this.tentheloai = tentheloai;
    }

    public int getTheloaiID() {
        return theloaiID;
    }

    public void setTheloaiID(int theloaiID) {
        this.theloaiID = theloaiID;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }
}
