package web;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户名和密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //调用MyBatis完成查询
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlsession对象
        SqlSession sqlsession = sqlSessionFactory.openSession();

        //获取Mapper
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        //调用方法
        User user = userMapper.selectlogin(username, password);
        //释放资源
        sqlsession.close();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        if(user!=null){
            writer.write("登录成功");
        }else {
            writer.write("登陆失败");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
