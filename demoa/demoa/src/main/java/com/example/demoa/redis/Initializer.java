package com.example.demoa.redis;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by yanyanho on 2017/7/18.
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {

    public Initializer() {
        super(RedisConfig.class);
    }
}
