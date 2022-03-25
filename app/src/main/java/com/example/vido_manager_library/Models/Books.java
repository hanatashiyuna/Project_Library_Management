package com.example.vido_manager_library.Models;

public class Books {
    private int sachID;
    private String tensach;
    private int tacgiaID;
    private int theloaiID;
    private int nhaxbID;
    private String namxb;
    private int soban;
    private int vitriID;

    public Books(int sachID, String tensach,
                 int tacgiaID, int theloaiID,
                 int nhaxbID, String namxb,
                 int soban, int vitriID) {
        this.sachID = sachID;
        this.tensach = tensach;
        this.tacgiaID = tacgiaID;
        this.theloaiID = theloaiID;
        this.nhaxbID = nhaxbID;
        this.namxb = namxb;
        this.soban = soban;
        this.vitriID = vitriID;
    }

    public int getSachID() {
        return sachID;
    }

    public void setSachID(int sachID) {
        this.sachID = sachID;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public int getTacgiaID() {
        return tacgiaID;
    }

    public void setTacgiaID(int tacgiaID) {
        this.tacgiaID = tacgiaID;
    }

    public int getTheloaiID() {
        return theloaiID;
    }

    public void setTheloaiID(int theloaiID) {
        this.theloaiID = theloaiID;
    }

    public int getNhaxbID() {
        return nhaxbID;
    }

    public void setNhaxbID(int nhaxbID) {
        this.nhaxbID = nhaxbID;
    }

    public String getNamxb() {
        return namxb;
    }

    public void setNamxb(String namxb) {
        this.namxb = namxb;
    }

    public int getSoban() {
        return soban;
    }

    public void setSoban(int soban) {
        this.soban = soban;
    }

    public int getVitriID() {
        return vitriID;
    }

    public void setVitriID(int vitriID) {
        this.vitriID = vitriID;
    }
}
