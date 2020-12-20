package com.chl.mybatis.dao;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public User getUserById(int id);
    public User getUserByIdName(@Param("id")  int id,@Param("name") String name);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
