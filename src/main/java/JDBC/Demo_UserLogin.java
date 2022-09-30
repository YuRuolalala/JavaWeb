package JDBC;

import java.sql.*;

public class Demo_UserLogin {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // write your code here

        //1·注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/db1";
        String username ="root";
        String password="123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        String name="zhangsan";
        String pwd="123456";

        String sql="select * from users where username='"+name+"' and password='"+pwd+"'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }

        connection.close();
    }
}
