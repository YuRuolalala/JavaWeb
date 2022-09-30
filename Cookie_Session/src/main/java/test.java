import mapper.UserMapper1;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.SqlSessionFactoryUtils;

public class test {


    @Test
    public void test(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper1 mapper = sqlSession.getMapper(UserMapper1.class);
        User user = mapper.selectlogin1("zhangsan", "123");

        System.out.println(user);
    }
}
