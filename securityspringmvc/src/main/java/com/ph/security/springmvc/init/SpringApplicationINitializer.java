package com.ph.security.springmvc.init;

import com.ph.security.springmvc.config.ApplicationConfig;
import com.ph.security.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author panhao
 * @date 2021年06月16日 6:22 下午
 */
public class SpringApplicationINitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //spring容器,相当于加载applicaitonContext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }
    //servletContext，相当于加载springmvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    //url-mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
