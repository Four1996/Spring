package com.itpanhao.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author panhao
 * @date 2021年04月08日 7:28 下午
 */
@Configuration//标志该类是spring的核心配置类
//<context:component-scan base-package="com.itpanhao"/>
@ComponentScan("com.itpanhao")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
