package com.chl.mybatis.service;

import com.chl.mybatis.dao.User;
import com.chl.mybatis.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class Mybatis_test {
    public SqlSessionFactory getsqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void test() throws IOException {

        SqlSession session =getsqlSessionFactory().openSession();

        try {
            User user = session.selectOne("selectUser", 1);
            System.out.println(user.toString());
        } finally {
            session.close();
        }


        //System.out.println("1");
    }
    @Test
    public void interfacetest() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();

        try {
            //获得接口的实现类对象
            UserMapper userMapper=session.getMapper(UserMapper.class);
            //调用接口方法
            User user=userMapper.getUserById(1);
            System.out.println(user.toString());
        } finally {
            session.close();
        }


        //System.out.println("1");
    }
}
