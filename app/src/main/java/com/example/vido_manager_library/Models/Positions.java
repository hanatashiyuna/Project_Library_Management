package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class Positions implements Serializable {
    private int vitriId;
    private String tenhang;

    public Positions(int vitriId, String tenhang) {
        this.vitriId = vitriId;
        this.tenhang = tenhang;
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
}
