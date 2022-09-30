package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("销毁。。。");
    }
}
