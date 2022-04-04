package com.example.vido_manager_library.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UserLectuters implements Serializable {
    private int thuthuId;
    private String hoten, ngaysinh, sdt,diachi, email,username,matkhau;
    private final List<Borrow> borrowLecturers = new ArrayList<Borrow>();
    private final List<GiveBack> givebackLecturers = new ArrayList<GiveBack>();

    public UserLectuters(int thuthuId, String hoten, String ngaysinh, String sdt, String diachi, String email, String username) {
        this.thuthuId = thuthuId;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.email = email;
        this.username = username;

    }

    public int getThuthuId() {
        return thuthuId;
    }

    public void setThuthuId(int thuthuId) {
        this.thuthuId = thuthuId;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public List<Borrow> getBorrowLecturers() {
        return borrowLecturers;
    }

    public List<GiveBack> getGivebackLecturers() {
        return givebackLecturers;
    }
}
