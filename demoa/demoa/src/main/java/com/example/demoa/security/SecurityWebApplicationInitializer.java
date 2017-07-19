package com.example.demoa.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by yanyanho on 2017/7/8.
 */

/**SecurityWebApplicationInitializer将会做下面的事情:
 自动为你的应用程序的每个URL注册springSecurityFilterChain 过滤器
 添加一个 ContextLoaderListener用来载入SecurityConfig. */

/**我们应该使用已经存在的ApplicationContext来注册Spring Security.举个例子，如果我们使用Spring MVC我们的SecurityWebApplicationInitializer应该看起来和下面的差不多*/
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}
