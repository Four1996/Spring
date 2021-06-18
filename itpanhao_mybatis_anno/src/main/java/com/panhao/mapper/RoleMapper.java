package com.panhao.mapper;

import com.panhao.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author panhao
 * @date 2021年06月01日 8:07 下午
 */
public interface RoleMapper {
    @Select("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=#{uid}")
    public List<Role> findByUid(int id);
}
