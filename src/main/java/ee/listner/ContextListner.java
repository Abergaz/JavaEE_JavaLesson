package ee.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("init context listener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("destroy context listener");
    }
}
