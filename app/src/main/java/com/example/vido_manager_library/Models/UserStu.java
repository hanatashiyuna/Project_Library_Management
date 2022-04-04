package com.example.vido_manager_library.Models;

import java.io.Serializable;
import java.util.List;

public class UserStu implements Serializable {
    private int sinhvienId;
    private String masosinhvien,tensinhvien,diachi,lop,email,matkhau,soCmnd,ngaysinh,khoa;
    private List<Borrow> borrowsStu;

    public UserStu(int sinhvienId, String masosinhvien, String tensinhvien, String diachi, String lop, String email, String matkhau, String soCmnd, String ngaysinh, String khoa) {
        this.sinhvienId = sinhvienId;
        this.masosinhvien = masosinhvien;
        this.tensinhvien = tensinhvien;
        this.diachi = diachi;
        this.lop = lop;
        this.email = email;
        this.matkhau = matkhau;
        this.soCmnd = soCmnd;
        this.ngaysinh = ngaysinh;
        this.khoa = khoa;
    }

    public int getSinhvienId() {
        return sinhvienId;
    }

    public void setSinhvienId(int sinhvienId) {
        this.sinhvienId = sinhvienId;
    }

    public String getMasosinhvien() {
        return masosinhvien;
    }

    public void setMasosinhvien(String masosinhvien) {
        this.masosinhvien = masosinhvien;
    }

    public String getTensinhvien() {
        return tensinhvien;
    }

    public void setTensinhvien(String tensinhvien) {
        this.tensinhvien = tensinhvien;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public List<Borrow> getBorrowsStu() {
        return borrowsStu;
    }

    public void setBorrowsStu(List<Borrow> borrowsStu) {
        this.borrowsStu = borrowsStu;
    }
}
