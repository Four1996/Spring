package com.itpanhao.aop;

/**
 * @author panhao
 * @date 2021年04月09日 10:12 上午
 */
public class Target implements TargetInterface {
    public void save() {
//        int i=1/0;
        System.out.println("save running...");
    }
}
