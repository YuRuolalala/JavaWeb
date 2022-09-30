package JDBC;

import JDBC.pojo.Account;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo01_Result {

    @Test
    public void testDQL1() throws Exception{
        //1·注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/db1";
        String username ="root";
        String password="123456";
        //2·获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //3·定义SQL语句
        String sql = "select * from account";
        //4·获取执行sql对象
        Statement statement = connection.createStatement();

        ResultSet rs=statement.executeQuery(sql);
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            double money=rs.getDouble("money");

            System.out.print(id+" ");
            System.out.print(name+" ");
            System.out.println(money);
        }
        rs.close();
        statement.close();
        connection.close();
    }


    @Test
    public void testDQL2() throws Exception{
        //1·注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://127.0.0.1:3306/db1";
        String username ="root";
        String password="123456";
        //2·获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //3·定义SQL语句
        String sql = "select * from account";
        //4·获取执行sql对象
        Statement statement = connection.createStatement();

        ResultSet rs=statement.executeQuery(sql);
        List<Account> list=new ArrayList<Account>();

        while(rs.next()){
            Account account = new Account();


            int id=rs.getInt("id");
            String name=rs.getString("name");
            double money=rs.getDouble("money");

            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            list.add(account);
        }
        for(Account i:list){
            System.out.println(i);
        }
        rs.close();
        statement.close();
        connection.close();
    }


}
