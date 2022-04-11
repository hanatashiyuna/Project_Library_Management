package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class Books implements Serializable {
    private int sachId;
    private String masach;
    private String tensach;
    private int tacgiaId;
    private int theloaiId;
    private int nhaXbid;
    private String namXb;
    private int soban;
    private int vitriId;

    public Books(String tensach, int soban) {
        this.tensach = tensach;
        this.soban = soban;
    }

    /*sachId: 1,
    masach: "LT1",
    tensach: "Lập trình C++",
    tacgiaId: 1,
    theloaiId: 1,
    nhaXbid: 1,
    namXb: 2010,
    soban: 5,
    vitriId: 1,
    img: "null",
    nhaXb: null,
    tacgia: null,
    theloai: null,
    vitri: null,
    muons: [ ],*/

    public Books(int sachId, String tensach, int tacgiaID, int theloaiID, int nhaxbID, String namxb, int soban, int vitriID) {
        this.sachId = sachId;
        this.tensach = tensach;
        this.tacgiaId = tacgiaID;
        this.theloaiId = theloaiID;
        this.nhaXbid = nhaxbID;
        this.namXb = namxb;
        this.soban = soban;
        this.vitriId = vitriID;
    }

    public Books(String masach, String tensach, int tacgiaID, int theloaiID, int nhaxbID, String namxb, int soban, int vitriID) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgiaId = tacgiaID;
        this.theloaiId = theloaiID;
        this.nhaXbid = nhaxbID;
        this.namXb = namxb;
        this.soban = soban;
        this.vitriId = vitriID;
    }

    public int getSachID() {
        return sachId;
    }

    public void setSachID(int sachID) {
        this.sachId = sachID;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getTacgiaID() {
        return tacgiaId;
    }

    public void setTacgiaID(int tacgiaID) {
        this.tacgiaId = tacgiaID;
    }

    public int getTheloaiID() {
        return theloaiId;
    }

    public void setTheloaiID(int theloaiID) {
        this.theloaiId = theloaiID;
    }

    public int getNhaxbID() {
        return nhaXbid;
    }

    public void setNhaxbID(int nhaxbID) {
        this.nhaXbid = nhaxbID;
    }

    public String getNamxb() {
        return namXb;
    }

    public void setNamxb(String namxb) {
        this.namXb = namxb;
    }

    public int getSoban() {
        return soban;
    }

    public void setSoban(int soban) {
        this.soban = soban;
    }

    public int getVitriID() {
        return vitriId;
    }

    public void setVitriID(int vitriID) {
        this.vitriId = vitriID;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }
}
