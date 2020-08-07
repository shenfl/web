package com.test.springboot.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author shenfl
 */
public class CustomAuthFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(CustomAuthFilter.class);
    private static ObjectMapper camelCaseMapper = createObjectMapper(
            PropertyNamingStrategy.LOWER_CAMEL_CASE);

    static ObjectMapper createObjectMapper(PropertyNamingStrategy strategy) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(strategy);
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        // disabled features:
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // register module
        SimpleModule simpleModule = new SimpleModule();
        mapper.registerModule(simpleModule);
        return mapper;
    }

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("启动[{}]...", getClass().getName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("request in");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String value = servletRequest.getHeader("X-Token");
        if (!StringUtils.isEmpty(value)) {
            try {
                UserUtil.setUser(camelCaseMapper.readValue(value, UserUtil.User.class));
                chain.doFilter(request, response);
            } finally {
                UserUtil.clear();
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}