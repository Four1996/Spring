package com.itpanhao.dao;



/**
 * @author panhao
 * @date 2021年05月21日 7:19 下午
 */
public interface AccountDao {

    public void out(String outMan,double money);
    public void in(String inMan,double money);
}
