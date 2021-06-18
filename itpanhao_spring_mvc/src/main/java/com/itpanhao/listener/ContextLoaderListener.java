package com.itpanhao.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author panhao
 * @date 2021年05月24日 3:30 下午
 */
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //        将Spring的应用上下文对象存储到ServletContext域中
        ServletContext servletContext = sce.getServletContext();
//        读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app=new ClassPathXmlApplicationContext(contextConfigLocation);

        servletContext.setAttribute("app",app);
        System.out.println("Spring 容器创建完毕");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
