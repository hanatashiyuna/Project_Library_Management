package com.example.vido_manager_library.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Authors implements Serializable {
    private int tacgiaId;
    private String tentacgia;
    private String ngaysinh;
    private List<Books> saches = new ArrayList<>();

    public Authors(int tacgiaId, String tentacgia, String ngaysinh) {
        this.tacgiaId = tacgiaId;
        this.tentacgia = tentacgia;
        this.ngaysinh = ngaysinh;
    }

    public Authors(String tentacgia, String ngaysinh) {
        this.tentacgia = tentacgia;
        this.ngaysinh = ngaysinh;
    }

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

    public List<Books> getSaches() {
        return saches;
    }

    public void setSaches(List<Books> saches) {
        this.saches = saches;
    }
}
