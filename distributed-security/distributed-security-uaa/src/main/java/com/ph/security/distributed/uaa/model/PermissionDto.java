package com.ph.security.distributed.uaa.model;

import lombok.Data;

/**
 * @program: securityspringboot
 * @description:
 * @author: panhao
 * @date: 2021-06-19 21:49
 **/
@Data
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
