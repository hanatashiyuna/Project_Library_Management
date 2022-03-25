package com.example.vido_manager_library.Admin.Model;

public class PC {
    private int nhaxbID;
    private String tenxuatban;
    private String diachi;
    private String email;
    private String thongtinnguoidaidien;

    public PC(int nhaxbID, String tenxuatban, String diachi, String email, String thongtinnguoidaidien) {
        this.nhaxbID = nhaxbID;
        this.tenxuatban = tenxuatban;
        this.diachi = diachi;
        this.email = email;
        this.thongtinnguoidaidien = thongtinnguoidaidien;
    }

    public int getNhaxbID() {
        return nhaxbID;
    }

    public void setNhaxbID(int nhaxbID) {
        this.nhaxbID = nhaxbID;
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
        return thongtinnguoidaidien;
    }

    public void setThongtinnguoidaidien(String thongtinnguoidaidien) {
        this.thongtinnguoidaidien = thongtinnguoidaidien;
    }
}
