package com.itpanhao.web;

import com.itpanhao.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author panhao
 * @date 2021年05月21日 9:44 下午
 */
public class UserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        ServletContext servletContext = this.getServletContext();
//        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }


}
