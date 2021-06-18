package com.itpanhao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itpanhao.domain.User;
import com.itpanhao.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月24日 7:20 下午
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/quick23")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save23(String username, MultipartFile[] upload) throws IOException{
        System.out.println(username);
        System.out.println(upload);
//        获得上传文件的名称
        int i=1;
        for (MultipartFile multipartFile:upload){
            multipartFile.transferTo(new File("/Users/phfile/Desktop/"+i+".txt"));
            i++;
        }
    }

    @RequestMapping(value = "/quick22")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save22(String username, MultipartFile upload) throws IOException{
        System.out.println(username);
        System.out.println(upload);
//        获得上传文件的名称
        String originalFilename = upload.getOriginalFilename();
        upload.transferTo(new File("/Users/phfile/Desktop/ccc.txt"));
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException{
        System.out.println(jsessionId);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save20(@RequestHeader(value = "User-Agent") String user_agent) throws IOException{
        System.out.println(user_agent);
    }




    @RequestMapping(value = "/quick19")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws IOException{
        System.out.println(request);
        System.out.println(response);
        System.out.println(httpSession);
    }


    @RequestMapping(value = "/quick18")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save18( Date date) throws IOException{
        System.out.println(date);
    }



//  localhost:8080/user/quick17/zhangsan
    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save17(@PathVariable(value = "username") String username) throws JsonProcessingException {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "zhangsan") String username) throws JsonProcessingException {
        System.out.println(username);
    }


    @RequestMapping(value = "/quick15")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save15(@RequestBody List<User> userList) throws JsonProcessingException {
        System.out.println(userList);
    }


    @RequestMapping(value = "/quick14")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save14(VO vo) throws JsonProcessingException {
        System.out.println(vo);
    }
    @RequestMapping(value = "/quick13")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save13(String[] strs) throws JsonProcessingException {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save12(User user) throws JsonProcessingException {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public void save11(String username,int age) throws JsonProcessingException {
        System.out.println(username);
        System.out.println(age);
    }


    @RequestMapping(value = "/quick10")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
//   期望SpringMVC自动将User转换成json格式的字符串
    public User save10() throws JsonProcessingException {
        User user=new User();
        user.setUsername("lisi2");
        user.setAge(222);
        return user;
    }
    @RequestMapping(value = "/quick9")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public String save9() throws JsonProcessingException {
        User user=new User();
        user.setUsername("lisi");
        user.setAge(22);
//        使用json的转换工具将对象转换成json格式字符串再返回
        ObjectMapper objectMapper=new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;

    }
    @RequestMapping(value = "/quick8")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public String save8(){
        return "{\"username\":\"zhangsan\",\"age\":\"18\"}";
    }
    @RequestMapping(value = "/quick7")
    @ResponseBody //告知spring mvc框架不进行视图跳转，直接进行数据相应
    public String save7(){
        return "wdnmd";
    }
    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response){
        try {
            response.getWriter().println("wdnmd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","hehe");
        return "success";
    }
    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username","wdnmd");
        return "success";
    }
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","heihei");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        /*
            Model:封装数据
            View：展示数据
         */
        ModelAndView modelAndView=new ModelAndView();
//        设置模型数据
        modelAndView.addObject("username","panhao");
//        设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }



    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("Controller save running.....");
        return "success";
    }
}
