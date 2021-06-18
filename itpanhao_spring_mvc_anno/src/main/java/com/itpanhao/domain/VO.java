package com.itpanhao.domain;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月25日 6:30 下午
 */
public class VO {
    private List<User> userList;

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
