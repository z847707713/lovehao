package cn.lovehao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ThreadStartUpListener implements ServletContextListener {

    private static WatchFilePathTask r = new WatchFilePathTask();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        r.run();
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        r.interrupt();
    }
}
