package com.test.springboot.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

public class MyWebAuthenticationDetails extends WebAuthenticationDetails {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MyWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        code = request.getParameter("code");
    }
}