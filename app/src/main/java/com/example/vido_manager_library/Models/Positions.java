package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class Positions implements Serializable {
    private int vitriId;
    private String tenhang;
    private String soke;

    public Positions(int vitriId, String tenhang,String soke) {
        this.vitriId = vitriId;
        this.tenhang = tenhang;
        this.soke = soke;
    }

    public Positions(String tenhang,String soke) {
        this.tenhang = tenhang;
        this.soke = soke;
    }

    public int getVitriId() {
        return vitriId;
    }

    public void setVitriId(int vitriId) {
        this.vitriId = vitriId;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getSoke() {
        return soke;
    }

    public void setSoke(String soke) {
        this.soke = soke;
    }
}
