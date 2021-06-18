package com.panhao.controller;

import com.panhao.exception.MyException;
import com.panhao.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

/**
 * @author panhao
 * @date 2021年05月28日 10:05 上午
 */
@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/show")
    public String show() throws FileNotFoundException, MyException {
        System.out.println("show running....");
//        demoService.show1();
//        demoService.show2();
//        demoService.show3();
//        demoService.show4();
        demoService.show5();

        return "index";
    }
}
