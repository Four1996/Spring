package com.panhao.controller;

import com.panhao.domain.Role;
import com.panhao.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 8:55 下午
 */

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/rolelist";
    }

    @RequestMapping("/rolelist")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList=roleService.list();
//        设置模型
        modelAndView.addObject("roleList",roleList);
//        设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
}
