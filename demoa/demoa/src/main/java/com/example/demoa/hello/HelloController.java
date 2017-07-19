package com.example.demoa.hello;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yanyanho on 2017/6/22.
 */
@Component
@RestController
@RefreshScope
public class HelloController {
    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;


    @RequestMapping(value = "/first")
    public String name() {
        return "world";
    }

    @RequestMapping(value = "/remote")
    public String remote() {
        return restTemplate.getForObject("http://localhost:5555/demo-b/remote", String.class);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
    }
}

    // @value("$kye")

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Dept> deptfind() {
////        Dept dept = new Dept();
////        dept.setCode("110");
////        dept.setName("hehe");
////        deptRepository.save(dept);
//        List<Dept> deptList = deptRepository.findAll();
//        for (int i = 0; i < deptList.size(); i++) {
//            System.out.println(deptList.get(i));
//        }
//        return deptList;
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public void deptsave(@RequestParam Dept dept) {
//        deptRepository.save(dept);
//    }

