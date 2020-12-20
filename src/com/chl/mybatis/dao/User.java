package com.chl.mybatis.dao;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {
    private int id;
    private String name;
    private String gender;

    public User() {
        super();
    }

    public User(int id, String name, String gender) {
        super();
        this.id = id;
        this.name = name;
        this.gender = gender;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
