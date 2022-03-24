package com.example.vido_manager_library.Models;

import java.io.Serializable;

public class UserLectuters implements Serializable {
    private int id, permission;
    private String nameLecturers, phoneLecturers;

    public UserLectuters(int id, int permission, String nameLecturers, String phoneLecturers) {
        this.id = id;
        this.permission = permission;
        this.nameLecturers = nameLecturers;
        this.phoneLecturers = phoneLecturers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getNameLecturers() {
        return nameLecturers;
    }

    public void setNameLecturers(String nameLecturers) {
        this.nameLecturers = nameLecturers;
    }

    public String getPhoneLecturers() {
        return phoneLecturers;
    }

    public void setPhoneLecturers(String phoneLecturers) {
        this.phoneLecturers = phoneLecturers;
    }
}
