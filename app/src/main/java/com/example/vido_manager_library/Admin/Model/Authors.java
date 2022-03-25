package com.example.vido_manager_library.Admin.Model;

import java.io.Serializable;

public class Authors implements Serializable {
    private int tacgiaId;
    private String tentacgia;
    private String ngaysinh;

    public Authors(int tacgiaId, String tentacgia, String ngaysinh) {
        this.tacgiaId = tacgiaId;
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
}
