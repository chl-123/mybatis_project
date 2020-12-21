package com.chl.mybatis.service;

import com.chl.mybatis.dao.Department;
import com.chl.mybatis.dao.User;
import com.chl.mybatis.dao.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Mybatis_test {
    public SqlSessionFactory getsqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void seletebyidtest() throws IOException {

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
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            User user= mapper.getUserById(1);
            System.out.println(user.toString());
        } finally {
            session.close();
        }


        //System.out.println("1");
    }
    @Test
    public void addtest() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();

        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            User user=new User();
            user.setName("吧");
            user.setGender("男");
            mapper.addUser(user);
            System.out.println(user.toString());
            session.commit();
        } finally {
            session.close();
        }


        //System.out.println("1");
    }
    @Test
    public void updtetest() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();

        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            User user=new User();
            user.setId(1);
            user.setName("小龙");
            user.setGender("男");
            mapper.updateUser(user);
            System.out.println(user.toString());
            session.commit();
        } finally {
            session.close();
        }

        //System.out.println("1");
    }
    @Test
    public void deletetest() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();

        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            mapper.deleteUser(6);
            //System.out.println(user.toString());
            session.commit();
        } finally {
            session.close();
        }

        //System.out.println("1");
    }
    @Test
    public void seleteByIdNametest() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();
        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            User user= mapper.getUserByIdName(1,"小龙");
            System.out.println(user.toString());
        } finally {
            session.close();
        }
        //System.out.println("1");
    }
    @Test
    public void seleteByNametest() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();
        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            List<User> list = mapper.getUserByName("%d%");
            System.out.println(list);
        } finally {
            session.close();
        }
        //System.out.println("1");
    }
    @Test
    public void seleteByNameReturnMaptest() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();
        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            Map<Integer, User> list = mapper.getUserByNameReturnMap("%d%");
            System.out.println(list);
        } finally {
            session.close();
        }
        //System.out.println("1");
    }
    @Test
    public void getUserAndDepttest() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();
        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            User user= mapper.getUserAndDept(1);
            System.out.println(user);
            System.out.println(user.getDepartment());
        } finally {
            session.close();
        }
        //System.out.println("1");
    }
    @Test
    public void getUserByStep() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();
        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            User user= mapper.getUserByIdStep(1);
            System.out.println(user.getName());
            System.out.println(user.getDepartment());
           // System.out.println(mapper.getDeptById(1));
        } finally {
            session.close();
        }
        //System.out.println("1");
    }
    @Test
    public void getDeptByIdPlus() throws IOException {
        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();
        try {
            //获得接口的实现类对象
            Mapper mapper =session.getMapper(Mapper.class);
            //调用接口方法
            Department department=mapper.getDeptByIdPlus(1);
            System.out.println(department);
            System.out.println(department.getUserList());
        } finally {
            session.close();
        }
        //System.out.println("1");
    }
}
