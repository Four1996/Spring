package com.ph.security.springmvc.service;

import com.ph.security.springmvc.model.AuthenticationRequest;
import com.ph.security.springmvc.model.UserDto;

/**
 * @author panhao
 * @date 2021年06月16日 6:35 下午
 */
public interface AuthenticationService {
    /*
     *
     * @author panhao
     * @date 2021/6/16 6:36 下午
 * @param authenticationService 用户认证请求，账户和密码
 * @return UserDao 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
