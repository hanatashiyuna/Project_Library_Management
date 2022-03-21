package com.example.vido_manager_library.Models;

public class UserDetailModels {

    /** ---------------------------------------
    * coursera: khoas hocj(khoas 14, 15, 16)
    * majors: nganh hoc(CNTT, DH, MMT)
    * ----------------------------------------
    **/
    public String name, classStudent, password, address, birthday, majors, phone;
    public int mssv, coursera;

    public UserDetailModels(String name, String classStudent) {
        this.name = name;
        this.classStudent = classStudent;
    }

    public UserDetailModels(String name, String classStudent, String password, String address, String birthday, String majors, String phone, int mssv, int coursera) {
        this.name = name;
        this.classStudent = classStudent;
        this.password = password;
        this.address = address;
        this.birthday = birthday;
        this.majors = majors;
        this.phone = phone;
        this.mssv = mssv;
        this.coursera = coursera;
    }

    public UserDetailModels(String name, String classStudent, String address, int mssv, String birthday, String phone, int coursera, String majors) {
        this.name = name;
        this.classStudent = classStudent;
        this.address = address;
        this.mssv = mssv;
        this.birthday = birthday;
        this.phone = phone;
        this.coursera = coursera;
        this.majors = majors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(String classStudent) {
        this.classStudent = classStudent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public int getCoursera() {
        return coursera;
    }

    public void setCoursera(int coursera) {
        this.coursera = coursera;
    }
}
