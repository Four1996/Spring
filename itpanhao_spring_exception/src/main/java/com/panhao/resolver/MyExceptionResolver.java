package com.panhao.resolver;

import com.panhao.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author panhao
 * @date 2021年05月29日 9:01 上午
 */


//自定义异常处理器
public class MyExceptionResolver implements HandlerExceptionResolver {
    /*
        参数Exception：异常对象
        返回值ModelAndView：跳转到错误视图信息页面
    */

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView=new ModelAndView();
        if (ex instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }else if (ex instanceof ClassCastException){
            modelAndView.addObject("info","类转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
