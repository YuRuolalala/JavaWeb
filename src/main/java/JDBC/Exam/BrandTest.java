package JDBC.Exam;

import JDBC.pojo.Brand;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    //查询所有数据

    /**
     * 1 SQL：select * from tb_brand;
     * 2 参数：不需要
     * 3 结果：List<Brand>
     */
    @Test
    public void testSelectAll() throws Exception {
        Properties prop=new Properties();
        prop.load(new FileInputStream("src\\main\\resources\\druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5.获取数据库连接
        Connection connection = dataSource.getConnection();

        String sql="select * from tb_brand";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Brand> list=new ArrayList<Brand>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            Brand brand=new Brand(id,brandName,companyName,ordered,description,status);
            list.add(brand);
        }

        for(Brand b:list){
            System.out.println(b);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    /**
     * 添加数据
     * 1·SQL:insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)
     * 2·参数：需要除了id之外的所有参数信息
     * 3·结果boolean
     */
    @Test
    public void testInsert() throws Exception {
        /**
         * 接收页面提交得参数
         */
        String brandName="香飘飘";
        String companyName="香飘飘";
        int ordered=1;
        String description="绕地球一圈";
        int status=1;


        Properties prop=new Properties();
        prop.load(new FileInputStream("src\\main\\resources\\druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5.获取数据库连接
        Connection connection = dataSource.getConnection();

        String sql="insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)";


        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);

        int i = preparedStatement.executeUpdate();

        if(i>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        preparedStatement.close();
        connection.close();

    }

    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {
        /**
         * 接收页面提交得参数
         */
        String brandName="香飘飘";
        String companyName="香飘飘";
        int ordered=1000;
        String description="绕地球三圈";
        int status=1;
        int id=4;


        Properties prop=new Properties();
        prop.load(new FileInputStream("src\\main\\resources\\druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //5.获取数据库连接
        Connection connection = dataSource.getConnection();

        String sql="insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?)";


        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,brandName);
        preparedStatement.setString(2,companyName);
        preparedStatement.setInt(3,ordered);
        preparedStatement.setString(4,description);
        preparedStatement.setInt(5,status);

        int i = preparedStatement.executeUpdate();

        if(i>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        preparedStatement.close();
        connection.close();

    }
}
