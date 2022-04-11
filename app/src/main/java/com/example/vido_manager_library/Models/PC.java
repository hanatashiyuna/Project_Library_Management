package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class PC implements Serializable {
    private int nhaXbid;
    private String tenxuatban;
    private String diachi;
    private String email;
    private String thongtinNguoiDaiDien;

    public PC(int nhaXbid, String tenxuatban, String diachi, String email, String thongtinNguoiDaiDien) {
        this.nhaXbid = nhaXbid;
        this.tenxuatban = tenxuatban;
        this.diachi = diachi;
        this.email = email;
        this.thongtinNguoiDaiDien = thongtinNguoiDaiDien;
    }

    public PC(String tenxuatban, String diachi, String email, String thongtinNguoiDaiDien) {
        this.tenxuatban = tenxuatban;
        this.diachi = diachi;
        this.email = email;
        this.thongtinNguoiDaiDien = thongtinNguoiDaiDien;
    }

    public int getNhaxbID() {
        return nhaXbid;
    }

    public void setNhaxbID(int nhaXbid) {
        this.nhaXbid = nhaXbid;
    }

    public String getTenxuatban() {
        return tenxuatban;
    }

    public void setTenxuatban(String tenxuatban) {
        this.tenxuatban = tenxuatban;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getThongtinnguoidaidien() {
        return thongtinNguoiDaiDien;
    }

    public void setThongtinnguoidaidien(String thongtinNguoiDaiDien) {
        this.thongtinNguoiDaiDien = thongtinNguoiDaiDien;
    }
}
