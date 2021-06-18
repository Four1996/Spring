package com.panhao.domain;

import java.util.Date;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月01日 4:40 下午
 */
public class User {
    private int id;
    private String username;
    private String password;
    private Date birthday;
//    一个用户具有哪些角色（多对多）
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", roleList=" + roleList +
                ", orderList=" + orderList +
                '}';
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    //    一个用户有哪些订单(一对多关系)
    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
