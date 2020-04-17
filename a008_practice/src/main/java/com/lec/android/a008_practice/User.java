package com.lec.android.a008_practice;

import java.io.Serializable;

public class User implements Serializable {

    int    photo;   // 사진
    String name;    // 이름
    int age;     // 나이
    String adress;  // 주소

    public User() {
    }

    public User(int photo, String name, int age, String adress) {
        this.photo = photo;
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAdress() {
        return adress;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
