package com.example.vido_manager_library.Models;

import java.io.Serializable;

/*
        "tensach": "Lập trình C++",
        "tentheloai": "Khoa học",
        "tentacgia": "Nguyễn Anh Kim Khoa",
        "tenxuatban": "Kim đồng",
        "namXb": 2010,
        "soban": 5,
        "soke": "s1.1",
        "img": "null"
        */
public class SearchBooks implements Serializable {
    private String tensach;
    private String tentheloai;
    private String tentacgia;
    private String tenxuatban;
    private int namXb;
    private int soban;
    private String soke;
    private String img;

    public SearchBooks(String tensach, String tentheloai, String tentacgia, String tenxuatban, int namXb, int soban, String soke, String img) {
        this.tensach = tensach;
        this.tentheloai = tentheloai;
        this.tentacgia = tentacgia;
        this.tenxuatban = tenxuatban;
        this.namXb = namXb;
        this.soban = soban;
        this.soke = soke;
        this.img = img;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }

    public String getTenxuatban() {
        return tenxuatban;
    }

    public void setTenxuatban(String tenxuatban) {
        this.tenxuatban = tenxuatban;
    }

    public int getNamXb() {
        return namXb;
    }

    public void setNamXb(int namXb) {
        this.namXb = namXb;
    }

    public int getSoban() {
        return soban;
    }

    public void setSoban(int soban) {
        this.soban = soban;
    }

    public String getSoke() {
        return soke;
    }

    public void setSoke(String soke) {
        this.soke = soke;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
