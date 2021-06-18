package com.panhao.service.impl;

import com.panhao.exception.MyException;
import com.panhao.service.DemoService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.PublicKey;

/**
 * @author panhao
 * @date 2021年05月28日 10:09 上午
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public void show1() {
        System.out.println("抛出类型转换异常...");
        Object str="zhangsan";
        Integer num= (Integer) str;
    }
    public void show2(){
        System.out.println("抛出除零异常...");
        int i=1/0;
    }
    public void show3() throws FileNotFoundException {
        System.out.println("文件找不到异常...");
        FileInputStream fileInputStream = new FileInputStream("usr/xxxxxxxx/xx.txt");

    }
    public void show4(){
        System.out.println("空指针异常...");
        String str=null;
        str.length();
    }
    public void show5() throws MyException {
        System.out.println("自定义异常...");
        throw new MyException();
    }
}
