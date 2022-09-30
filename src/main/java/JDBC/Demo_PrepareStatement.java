package JDBC;

import java.sql.*;

public class Demo_PrepareStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // write your code here

        //1·注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String name = "zhangsan";
        String pwd = "123456";

        String sql="select * from users where username=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pwd);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }

        connection.close();
    }
}
