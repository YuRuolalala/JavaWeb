package service;

import mapper.UserMapper1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import utils.SqlSessionFactoryUtils;


public class UserService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登陆方法
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper1 userMapper1 = sqlSession.getMapper(UserMapper1.class);

        User user = userMapper1.selectlogin1(username, password);

        sqlSession.close();




        return user;
    }
}
