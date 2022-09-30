package test;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;

public class testMybatis {

    @Test
    public void testAdd() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        User user = userMapper.selectlogin("zhangsan", "123");

        Integer integer= null;
        try {
            integer = userMapper.addAccount("zhaoliu","123");
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(integer);
        }
        if(integer==null){
            System.out.println("添加失败");
        }else{
            System.out.println("添加成功");
        }


    }
}
