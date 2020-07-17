package com.test.cloud.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 默认增加返回值格式
 * {
 *     "success": true/false,
 *     "code": 200,
 *     "message": "bingo"
 *     "data": {
 *     }
 * }
 * @author shenfl
 */
@Component
public class MyHandlerAdapter extends RequestMappingHandlerAdapter {

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>();
        Objects.requireNonNull(getReturnValueHandlers()).forEach(h->{
            if (h instanceof RequestResponseBodyMethodProcessor) {
                handlers.add(new ResultHandlerMethodReturnValueHandler((RequestResponseBodyMethodProcessor) h));
            } else {
                handlers.add(h);
            }
        });
        setReturnValueHandlers(handlers);
    }
}