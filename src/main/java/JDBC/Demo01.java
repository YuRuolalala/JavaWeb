package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // write your code here

        //1·注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/db1";
        String username ="root";
        String password="123456";
        //2·获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //3·定义SQL语句
        String sql = "update account set moeny = 2000 where id =1";
        //4·获取执行sql对象
        Statement statement = connection.createStatement();
        //5·执行sql
        int count=statement.executeUpdate(sql);
        //6·处理返回结果
        System.out.println(count);
        //7·释放资源
        statement.close();
        connection.close();
    }
}
