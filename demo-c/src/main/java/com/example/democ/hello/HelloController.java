package com.example.democ.hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanyanho on 2017/6/22.
 */
@RestController
@EnableAutoConfiguration
public class HelloController {
 @RequestMapping(value="/name")
 public String name(){
     return "hello";
 }
}
