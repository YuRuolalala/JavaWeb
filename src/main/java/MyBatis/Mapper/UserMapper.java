package MyBatis.Mapper;

import MyBatis.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);
}
