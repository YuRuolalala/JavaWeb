package web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet(urlPatterns = "/demo02",loadOnStartup = 0)
public class ServletDemo02 implements Servlet {
    private ServletConfig config;
    /**
     * 初始化方法
     * 1·调用时机：默认情况下，Servlet被第一次访问时调用
     * 2·调用次数：1次
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config=config;
        System.out.println("init...");
    }

    /**
     * 提供服务的方法
     * 1·调用时机：每一次Servlet调被访问时
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet hello world~");
    }

    /**
     * 销毁方法
     * 1·调用时机：内存释放的时候，服务器关闭的时候。Servlet会被销毁，调用
     * 2·调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("destory");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }
}
