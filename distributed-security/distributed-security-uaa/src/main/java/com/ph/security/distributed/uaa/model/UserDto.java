package com.ph.security.distributed.uaa.model;

import lombok.Data;

/**
 * @program: securityspringboot
 * @description:
 * @author: panhao
 * @date: 2021-06-19 16:57
 **/
@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
