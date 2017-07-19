package com.example.demob.redis;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by yanyanho on 2017/7/18.
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {

    public Initializer() {
        super(Config.class);
    }
}
