package MyBatis.Test;

import MyBatis.Mapper.BrandMapper;
import MyBatis.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    @Test
    public void testSelectAll() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlsession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        sqlsession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlsession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(2);
        System.out.println(brand);

        sqlsession.close();
    }

    @Test
    public void testSelectByCondition01() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlsession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);

        Brand brand=new Brand();
//        brand.setBrandName("华为");
//        brand.setCompanyName("华为");
//        brand.setStatus(1);

//        List<Brand> brands0 = brandMapper.selectByCondition(1,"华为","");
        List<Brand> brands1 = brandMapper.selectByCondition(brand);
        System.out.println(brands1);

        sqlsession.close();
    }

    @Test
    public void testAdd() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlsession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);

        Brand brand = new Brand("手机", "中国电信", 50, "中国电信，你别不信", 1);
        brandMapper.add(brand);
//        sqlsession.commit();

        sqlsession.close();
    }

    @Test
    public void testAdd2() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlsession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);

        Brand brand = new Brand("手机", "中国电信", 50, "中国电信，你别不信", 1);
        brandMapper.add(brand);
//        sqlsession.commit();
        System.out.println(brand.getId());

        sqlsession.close();
    }

    @Test
    public void update() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlsession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);

        Brand brand = new Brand(8,"手机", "", 100, "中国联通，一连就通", 1);
        int update = brandMapper.update(brand);
        System.out.println(update);

        sqlsession.close();
    }

    @Test
    public void deleteById() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlsession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);

        brandMapper.deleteById(8);

        sqlsession.close();
    }

    @Test
    public void deleteByIds() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlsession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlsession.getMapper(BrandMapper.class);
        int[] arr={9,10,11};
        brandMapper.deleteByIds(arr);

        sqlsession.close();
    }

}
