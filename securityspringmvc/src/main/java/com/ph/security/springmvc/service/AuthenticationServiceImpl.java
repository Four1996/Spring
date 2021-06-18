package com.ph.security.springmvc.service;

import com.ph.security.springmvc.model.AuthenticationRequest;
import com.ph.security.springmvc.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author panhao
 * @date 2021年06月16日 6:43 下午
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    /*
     * 用户认证，校验用户身份信息是否合法
     * @author panhao
     * @date 2021/6/16 6:44 下午
     * @param authenticationRequest
     * @return com.ph.security.springmvc.model.UserDto
     */
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        // 校验参数是否为空
        if (authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
                || StringUtils.isEmpty(authenticationRequest.getPassword())) {
            throw new RuntimeException("账号和密码为空");
        }
        // 根据账号去查询数据库，这里测试程序采用模拟方法
        UserDto user = getUserDto(authenticationRequest.getUsername());
        // 判断用户是否为空
        if (user == null) {
            throw new RuntimeException("查询不到该账户");
        }
        // 校验密码
        if (!authenticationRequest.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("密码错误");

        }
        // 认证通过，返回用户身份信息
        return user;
    }

    // 根据账号查询用户信息
    private UserDto getUserDto(String username) {
        return userMap.get(username);
    }

    // 用户信息
    private Map<String, UserDto> userMap = new HashMap<>();
    {
        Set<String> authoriries1 = new HashSet<>();
        authoriries1.add("p1");//这个p1我们认为让它和/r/r1对应
        Set<String> authoriries2 = new HashSet<>();
        authoriries2.add("p2");//这个p2我们人为让它和/r/r2对应
        userMap.put("zhangsan", new UserDto("1010", "zhangsan", "123", "张三", "133443", authoriries1));
        userMap.put("lisi", new UserDto("1011", "lisi", "456", "李四", "144553", authoriries2));

    }
}
