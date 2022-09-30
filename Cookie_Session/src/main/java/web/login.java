package web;

import pojo.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {
    private UserService service=new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user=service.login(username,password);

        if(user!=null){
            //将登录成功后的对象，存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            String contextPath=request.getContextPath();
            response.sendRedirect(contextPath+"/selectAll");
        }else {
            //登陆失败
            //将错误信息存储到request中
            request.setAttribute("login_msg","用户名或密码错误");

            request.getRequestDispatcher("/login.html").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
