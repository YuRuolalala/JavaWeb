package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01_Statement {
    @Test
    public void testDML() throws Exception{
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
        int count=statement.executeUpdate(sql);//执行完DLM语句，受影响的行数
        //6·处理返回结果
        if(count>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        //7·释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testDDL() throws Exception{
        //1·注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/db1";
        String username ="root";
        String password="123456";
        //2·获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //3·定义SQL语句
        String sql = "create database db2";
        //4·获取执行sql对象
        Statement statement = connection.createStatement();
        //5·执行sql
        int count=statement.executeUpdate(sql);//执行完DDL语句，受影响的行数
        //6·处理返回结果
//        if(count>0){
//            System.out.println("修改成功");
//        }else {
//            System.out.println("修改失败");
//        }
        //7·释放资源
        statement.close();
        connection.close();
    }
}
