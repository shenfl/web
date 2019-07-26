package com.test.springboot.security;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()//用户详细存储在内存
                .withUser("user").password("123").authorities("auth")//创建一个用户
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());//不加密

        auth.authenticationProvider(authenticationProvider());
    }
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated().and()
                .formLogin() //配置Details源
                .authenticationDetailsSource(authenticationDetailsSource()).and()
                .csrf().disable();
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new AuthenticationProvider() {
            //检查入参Authentication是否是UsernamePasswordAuthenticationToken或它的子类
            public boolean supports(Class<?> authentication) {
                return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
            }

            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                //第4篇讲过的其他参数，默认details类型中包含用户ip和sessionId
                WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
                //用户名和密码
                String username = authentication.getName();
                String password = authentication.getCredentials().toString();
                //根据以上参数，自定义认证逻辑，系统默认实现就是在此读取UserDetails认证密码
                //这里只给个简化逻辑，验证密码是否是123，实际中要根据具体业务来实现
                if(!password.equals("123")){
                    throw new BadCredentialsException("密码错误");
                }
                // 认证通过，从数据库中查询用户权限
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("ROLE_role1"));
                //生成已认证Authentication，系统会将其写入SecurityContext
                return new UsernamePasswordAuthenticationToken(username, password, authorities);
            }
        };
    }
    @Bean
    public AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource() {
        return new AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>() {
            public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
                return new MyWebAuthenticationDetails(context);//配置Details类型
            }
        };
    }
}