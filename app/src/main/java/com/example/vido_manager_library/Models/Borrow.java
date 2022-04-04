package com.example.vido_manager_library.Models;

import java.io.Serializable;
import java.util.List;

/*muonId: 1,
        masosinhvien: "1906020173",
        sinhvienId: 1,
        thuthuId: 1,
        sachId: 1,
        ngaymuon: "2022-03-23T00:00:00",

        tras: [ ],*/

public class Borrow implements Serializable {
    private int muonId,sinhvienId,thuthuId,sachId;
    private String masosinhvien,ngaymuon;
    private List<GiveBack> giveBacks;

    public int getMuonId() {
        return muonId;
    }

    public void setMuonId(int muonId) {
        this.muonId = muonId;
    }

    public int getSinhvienId() {
        return sinhvienId;
    }

    public void setSinhvienId(int sinhvienId) {
        this.sinhvienId = sinhvienId;
    }

    public int getThuthuId() {
        return thuthuId;
    }

    public void setThuthuId(int thuthuId) {
        this.thuthuId = thuthuId;
    }

    public int getSachId() {
        return sachId;
    }

    public void setSachId(int sachId) {
        this.sachId = sachId;
    }

    public String getMasosinhvien() {
        return masosinhvien;
    }

    public void setMasosinhvien(String masosinhvien) {
        this.masosinhvien = masosinhvien;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public List<GiveBack> getGiveBacks() {
        return giveBacks;
    }

    public void setGiveBacks(List<GiveBack> giveBacks) {
        this.giveBacks = giveBacks;
    }
}
