package com.itpanhao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.SchemaOutputResolver;

/**
 * @author panhao
 * @date 2021年05月26日 3:08 下午
 */
public class MyInterceptor1 implements HandlerInterceptor {
//    是在目标方法执行之前 执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle.....");
        String param = request.getParameter("param");
        //        返回true代表放行，返回false代表不放行
        if ("yes".equals(param))return true;
        else{
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;
        }
    }
//  是在目标方法执行之后 视图返回之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }
//在整个流程都执行完毕后  执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion.....");
    }
}
