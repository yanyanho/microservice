package com.example.demob.remote;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanyanho on 2017/7/5.
 */
@RestController
@EnableAutoConfiguration
public class RemoteProviderController {

    @RequestMapping(value="/remote")
    public String remoteProvider( String s){
        return  s+"hello world";
    }
}
