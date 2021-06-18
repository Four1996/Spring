package com.ph.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author panhao
 * @date 2021年06月16日 6:37 下午
 */
@Data
@AllArgsConstructor
public class UserDto {

    public static final String SESSION_USER_KEY="_user";
    //用户身份信息
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
    // 用户权限
    private Set<String> authorities;
}
