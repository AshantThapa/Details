package com.m.details.model;

public class UserDetail {

    private String name;
    private int age;
    private String gender;
    private int imageId;

    public UserDetail(String name, int age, String gender, int imageId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.imageId = imageId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}



