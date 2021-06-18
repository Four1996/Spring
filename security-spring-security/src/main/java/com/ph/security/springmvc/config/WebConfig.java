package com.ph.security.springmvc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author panhao
 * @date 2021年06月16日 6:10 下午
 */
@Configuration//相当于springmvc.xml文件
@EnableWebMvc()
@ComponentScan(basePackages = "com.ph.security.springmvc"
        ,includeFilters ={@ComponentScan.Filter(type= FilterType.ANNOTATION,value = Controller.class)} )
public class WebConfig implements WebMvcConfigurer {
    // @Autowired
    // SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;

    //视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(simpleAuthenticationInterceptor).addPathPatterns("/r/**");
    // }
}
