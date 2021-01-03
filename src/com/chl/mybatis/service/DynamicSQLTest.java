package com.chl.mybatis.service;

import com.chl.mybatis.dao.Department;
import com.chl.mybatis.dao.DynamicSqlMapper;
import com.chl.mybatis.dao.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class DynamicSQLTest {
    public SqlSessionFactory getsqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void getUsertest() throws IOException {

        //获得sqlsession对象
        SqlSession session =getsqlSessionFactory().openSession();

        try {
            //获得接口的实现类对象
            DynamicSqlMapper mapper =session.getMapper(DynamicSqlMapper.class);
            //利用ID查，如果有其他条件就附加上去
            /*User user=new User(1,"小龙",null,null);
            List<User> list=mapper.getUserByConditionIf(user);*/
            //<!-- 如果带了id就用id查，如果带了lastName就用lastName查;只会进入其中一个 -->
            /*User user=new User(null,"小龙",null,null);
            List<User> list=mapper.getUserByConditionChoose(user);*/
            //根据需要更新数据库数据
            /*User user=new User(1,"小力",null,null);
            mapper.updateUser(user);
            session.commit();*/
            //批量打印
            //List<User> list=mapper.getUserByConditionForeach(Arrays.asList(1,2));
            User user=new User(null,"小红","男",new Department(1,null));
            List<User> list =new ArrayList<>();
            list.add(user);


            mapper.addUser(list);
            session.commit();
            //System.out.println(list);
        } finally {
            session.close();
        }

    }
}
