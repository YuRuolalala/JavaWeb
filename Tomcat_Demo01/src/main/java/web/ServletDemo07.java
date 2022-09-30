package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/demo07")
public class ServletDemo07 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);

        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL.toString());

        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        String queryString = req.getQueryString();
        System.out.println(queryString);


        String agent = req.getHeader("user-agent");
        System.out.println(agent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        post请求体:
        //1·获取字符输入流
        BufferedReader bufferedReader = req.getReader();
        //2·读取数据
        String line = bufferedReader.readLine();
        System.out.println(line);

    }
}
