package com.ph.security.springmvc.interceptor;

import com.ph.security.springmvc.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: securityspringmvc
 * @description: 拦截器
 * @author: panhao
 * @date: 2021-06-16 20:45
 **/
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在这个方法当中校验用户请求的url是否在用户的权限范围内
        // 取出用户身份信息
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object==null){
             writeContent(response,"请登录");
             return false;
        }
        UserDto userDto= (UserDto) object;
        // 请求的url
        String requestURI = request.getRequestURI();
        if (userDto.getAuthorities().contains("p1")&&requestURI.contains("/r/r1")){
            return true;
        }
        if (userDto.getAuthorities().contains("p2")&&requestURI.contains("r/r2")){
            return true;
        }
        writeContent(response,"没有权限，拒绝访问");
        return false;
    }
    // 响应信息给客户端
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(msg);
        writer.close();
    }

}
