package com.example.demoeureka.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanyanho on 2017/7/19.
 */
@RestController
public class HelloWorld {

    @Value("${key}")
    String key;

    @RequestMapping(value = "/second")
    public String name() {
        return "world"+key;
    }
}
