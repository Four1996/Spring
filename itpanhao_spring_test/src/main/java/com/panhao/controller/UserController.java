package com.panhao.controller;

import com.panhao.domain.Role;
import com.panhao.domain.User;
import com.panhao.service.RoleService;
import com.panhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月26日 10:26 下午
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
        userService.del(userId);

        return "redirect:/user/userlist";
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roleIds){
        userService.save(user,roleIds);

        return "redirect:/user/userlist";
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/userlist")
    public ModelAndView list(){
        List<User> userList=userService.list();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
