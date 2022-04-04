package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class GiveBack implements Serializable {
    private int traId, muonId,thuthuId;
    private String ngaytra;



    public int getTraId() {
        return traId;
    }

    public void setTraId(int traId) {
        this.traId = traId;
    }

    public int getMuonId() {
        return muonId;
    }

    public void setMuonId(int muonId) {
        this.muonId = muonId;
    }

    public int getThuthuId() {
        return thuthuId;
    }

    public void setThuthuId(int thuthuId) {
        this.thuthuId = thuthuId;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }
}
