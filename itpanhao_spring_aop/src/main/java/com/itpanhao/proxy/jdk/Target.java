package com.itpanhao.proxy.jdk;

/**
 * @author panhao
 * @date 2021年04月09日 10:12 上午
 */
public class Target implements TargetInterface{

    public void save() {
        System.out.println("save running...");
    }
}
