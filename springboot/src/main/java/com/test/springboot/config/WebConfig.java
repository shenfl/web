package com.test.springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author shenfl
 */
@Configuration // spring模式注解
public class WebConfig {
    /**
     *  注入filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<CustomAuthFilter> customAuthFilterFilterRegistrationBean() {
        FilterRegistrationBean<CustomAuthFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomAuthFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }
}
