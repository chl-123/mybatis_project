package com.chl.mybatis.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Mapper {

    public User getUserById(int id);
    public User getUserByIdName(@Param("id")  int id,@Param("name") String name);
    public List<User> getUserByName(String name);
    //告诉Mybatis封装Map时以什么为主键
    @MapKey("name")
    public Map<Integer,User> getUserByNameReturnMap(String name);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);

    public User getUserAndDept(int id);

    public User getUserByIdStep(int id);
    public Department getDeptById(int id);
    public Department getDeptByIdPlus(int id);
}
