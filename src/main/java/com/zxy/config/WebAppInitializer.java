package com.zxy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @date: 2018/5/3
 * @author: Mr.zxy
 * message:
 * 这种配置，只能应用于Servlet 3.0 的服务器中才能正常工作。
 */

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * DispatcherServlet 启动的时候，会创建spring应用的上下文，并架子啊配置文件或配置类中所声明的bean.
     * 该方法在中，我们要求DispatcherServlet加载应用上下文时，使用定义再WebConfig配置类的中的bean。
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 将dispatcherServlet 映射到  /
     * 这表示他会是应用默认的servlet,所有的请求都会进入处理。
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
