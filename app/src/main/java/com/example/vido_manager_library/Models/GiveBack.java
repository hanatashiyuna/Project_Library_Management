package com.example.vido_manager_library.Models;

import java.io.Serializable;

/*		"traId": 1,
                "muonId": 1,
                "thuthuId": 1,
                "ngaytra": "2020-06-01T00:00:00"
                */
public class GiveBack implements Serializable {
    private int traId, muonId,thuthuId;
    private String ngaytra;

    public GiveBack(int traId, int muonId, int thuthuId, String ngaytra) {
        this.traId = traId;
        this.muonId = muonId;
        this.thuthuId = thuthuId;
        this.ngaytra = ngaytra;
    }

    public GiveBack(int muonId, int thuthuId, String ngaytra) {
        this.muonId = muonId;
        this.thuthuId = thuthuId;
        this.ngaytra = ngaytra;
    }

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
