package com.itpanhao.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author panhao
 * @date 2021年05月24日 3:55 下午
 */
public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
