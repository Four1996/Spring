package com.ph.security.springmvc.model;

import lombok.Data;

/**
 * @author panhao
 * @date 2021年06月16日 6:38 下午
 */
@Data
public class AuthenticationRequest {
//    认证请求的参数,账户、密码...
    //用户名
    private String username;
    //密码
    private String password;
}
