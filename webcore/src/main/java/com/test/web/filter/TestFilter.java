package com.test.web.filter;

import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.representations.AccessToken;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by shenfl on 2020-02-13
 * 用于keycloak的demo
 * http://www.pianshen.com/article/6397126319/
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        RefreshableKeycloakSecurityContext context
                =  (RefreshableKeycloakSecurityContext)request.getAttribute("org.keycloak.KeycloakSecurityContext");
        //或者
        //=  (RefreshableKeycloakSecurityContext)request.getSession().getAttribute("org.keycloak.KeycloakSecurityContext");
        AccessToken token = context.getToken();
        String sub = token.getSubject();//用户内码
        System.out.println(sub);
        String loginName = token.getPreferredUsername();//登录账号
        System.out.println(loginName);

        //Realm角色列表
        AccessToken.Access access = token.getRealmAccess();
        Set<String> roles =  access.getRoles();
        System.out.println(roles);

        //client角色列表
        //Map<clientId,roleList>
        Map<String, AccessToken.Access> ma = token.getResourceAccess();
        for (String key : ma.keySet()) {
            System.out.println(key);//clientID
            //当前用户在key client中拥有的角色列表
            System.out.println(ma.get(key).getRoles());

        }
        //构建业务应用自己的安全上下文
        request.getSession().setAttribute("loginName", loginName);

        //请求继续传递
        chain.doFilter(req, res);
    }


    @Override
    public void destroy() {

    }
}
