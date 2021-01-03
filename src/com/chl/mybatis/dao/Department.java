package com.chl.mybatis.dao;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("department")
public class Department {
    private int id;
    private String deptname;
    private List<User>  userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Department(int id, String deptname) {
        super();
        this.id = id;
        this.deptname = deptname;
    }

    public Department() {
        super();
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
