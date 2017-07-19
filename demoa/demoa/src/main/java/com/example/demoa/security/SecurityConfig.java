package com.example.demoa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


/**
 * Created by yanyanho on 2017/7/8.
 */

/**
 * 1用户使用用户名和密码进行登录。
 * 2 Spring Security 将获取到的用户名和密码封装成一个实现了 Authentication 接口的 UsernamePasswordAuthenticationToken。
 * 3 将上述产生的 token 对象传递给 AuthenticationManager 进行登录认证。
 * 4 AuthenticationManager 认证成功后将会返回一个封装了用户权限等信息的 Authentication 对象。
 * 通过调用 SecurityContextHolder.getContext().setAuthentication(...) 将 AuthenticationManager 返回的 Authentication 对象赋予给当前的 SecurityContext。
 */
// SecurityConfig 只包含了关于如何验证我们的用户的信息
//AuthenticationManager - 处理来自框架其他部分的认证请求
//AccessDecisionManager - 为网页和方法安全提供访问决策，会注册一个默认的但是你可以使用一个定制的来取代他，使用一般的Spring bean语法即可定义.
// AuthenticationProviders - 认证管理器认证用户的机制，命名空间提供多种标准选项的支持，同时使用传统语法添加自定义bean的方法。
//UserDetailsService - 和AuthenticationProviders密切相关，但往往也被其他bean需要。
@EnableWebSecurity
public class SecurityConfig {
    //    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()           //内存验证
//                .withUser("user1").password("password").roles("USER").
//                and().
//                withUser("admin").password("password").roles("USER", "ADMIN");;
//    }
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?")
                //.passwordEncoder(passwordEncoder())
                .dataSource(dataSource);


    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
