package com.panhao.service;

import com.panhao.exception.MyException;

import java.io.FileNotFoundException;

/**
 * @author panhao
 * @date 2021年05月28日 10:07 上午
 */
public interface DemoService {
    public void show1();
    public void show2();
    public void show3() throws FileNotFoundException;
    public void show4();
    public void show5() throws MyException;
}
