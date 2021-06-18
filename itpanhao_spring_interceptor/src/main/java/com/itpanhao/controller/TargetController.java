package com.itpanhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author panhao
 * @date 2021年05月26日 2:55 下午
 */
@Controller
public class TargetController {
    @RequestMapping("/target")
    public ModelAndView show(){
        System.out.println("目标资源执行.....");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","panhao");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
