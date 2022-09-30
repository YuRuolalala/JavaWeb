package mapper;


import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper1 {

    User selectlogin1(@Param("username")String username, @Param("password")String password);

    User selectByUsername1(String username);

    int addAccount1(@Param("username")String username, @Param("password")String password);
}
