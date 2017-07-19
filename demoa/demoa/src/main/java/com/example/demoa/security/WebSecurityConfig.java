package com.example.demoa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.sql.DataSource;

/**
 * Created by yanyanho on 2017/7/8.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll() // 以"/home/" 开头的URL只能由拥有 "ROLEADMIN"角色的用户访问.
                .anyRequest().authenticated()
                .and()
                .requestCache()
                .requestCache(new NullRequestCache())
                .and()
                .httpBasic()
              //  .formLogin()
            //    .successForwardUrl("/first")
                //.loginPage("/login")
          //      .permitAll()  //formLogin().permitAll() 方法允许基于表单登录的所有URL的所有用户的访问。
                .and()
                .logout()      //使Session无效 清除所有已经配置的RememberMe认证 清除SecurityContextHolder 跳转到/login?success
                .invalidateHttpSession(true)  // 5
                .deleteCookies() //7
                .permitAll();
    }

}
