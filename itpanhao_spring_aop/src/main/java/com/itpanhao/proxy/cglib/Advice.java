package com.itpanhao.proxy.cglib;

/**
 * @author panhao
 * @date 2021年04月09日 10:13 上午
 */
public class Advice {
    public void before(){
        System.out.println("前值增强...");
    }
    public void afterReturning(){
        System.out.println("后置增强...");
    }
}
