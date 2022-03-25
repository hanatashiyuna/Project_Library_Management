package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class UserAuthor implements Serializable {
    private int tacgiaId;
    private String tentacgia;
    private String ngaysinh;
    //private String saches;


    public int getTacgiaId() {
        return tacgiaId;
    }

    public void setTacgiaId(int tacgiaId) {
        this.tacgiaId = tacgiaId;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    /*public String getSaches() {
        return saches;
    }

    public void setSaches(String saches) {
        this.saches = saches;
    }*/
}
