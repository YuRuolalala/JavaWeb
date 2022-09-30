package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {

    User selectlogin(@Param("username")String username, @Param("password")String password);

    User selectByUsername(String username);

    Integer addAccount(@Param("username")String username, @Param("password")String password);
}
