package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 1·放行前，对request数据进行处理
        System.out.println("1·FilterDemo...");

        chain.doFilter(request,response);
        // 2·放行后，对response数据进行处理
        System.out.println("3·FilterDemo");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }



    @Override
    public void destroy() {

    }
}
