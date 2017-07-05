package com.example.demoa.hello;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yanyanho on 2017/6/22.
 */
@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/name")
    public String name() {
        return "world";
    }

    @RequestMapping(value = "/remote")
    public String remote() {
        RestTemplate restTemplate1= new RestTemplate();
        return restTemplate1.getForObject("http://localhost:5555/demo-b/remote", String.class);

    }

}
