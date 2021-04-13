package com.xf.config;

import com.xf.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new CorsFilter());
        registration.addUrlPatterns("/*"); //拦截规则
        registration.setName("corsFilter");
        return registration;
    }
}

