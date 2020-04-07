package com.kongming.mybatis.demo.server;

import com.kongming.mybatis.demo.dao.UserMapper;
import com.kongming.mybatis.demo.domain.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            //User user = sqlSession.selectOne("MyMapper.selectUser", 1);
            //System.out.println(user);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.queryUserAll();
            for (User user : userList) {
                System.out.println(user);
            }

        } finally {
            sqlSession.close();
        }
    }
}
