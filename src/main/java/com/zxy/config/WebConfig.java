package com.zxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @date: 2018/5/3
 * @author: Mr.zxy
 * message:
 */
@Configuration
//启用spring MVC
@EnableWebMvc
//启动组件扫描
@ComponentScan("com.zxy")
public class WebConfig extends WebMvcConfigurerAdapter{

    //配置JSP视图解析器
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //视图名称前缀
        viewResolver.setPrefix("WEB-INF/views");
        //视图名称后缀
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);
        return  viewResolver;
    }
    /**
     *配置静态资源处理
     * 通过调用enable方法，我们要求DispatcherServlet将对静态资源的请求转发的Servlet容器中默认的servelet上
     * 而不是使用DispatcherServlet类处理此类请求
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
