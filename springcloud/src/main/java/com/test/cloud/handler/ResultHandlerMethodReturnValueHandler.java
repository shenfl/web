package com.test.cloud.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

/**
 * @author shenfl
 */
public class ResultHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private RequestResponseBodyMethodProcessor processor;

    public ResultHandlerMethodReturnValueHandler(RequestResponseBodyMethodProcessor processor) {
        this.processor = processor;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return processor.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        returnValue = StandardResult.succeeded(returnValue);
        processor.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }
}