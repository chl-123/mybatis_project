package com.chl.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSqlMapper {


    public List<User> getUserByConditionIf(User user);
    public List<User> getUserByConditionChoose(User user);
    public void updateUser(User user);
    public List<User> getUserByConditionForeach(@Param("ids")List<Integer> ids);
    public void addUser(@Param("users")List<User> users);

}
