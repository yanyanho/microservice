package com.example.demoa.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yanyanho on 2017/7/16.
 */
@RestController
public class MessageController {
    @Autowired
    private CacheService cacheService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public List<String> greeting(String user) {
        List<String> messages = cacheService.listMessages(user);
        return messages;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(String user, String message) {
        cacheService.addMessage(user, message);
        return "OK";
    }

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public void redis(HttpServletRequest request,String action, String msg) {
        if(action.equals("set")) {
            request.getSession().setAttribute("msg", msg);
        }

        stringRedisTemplate.opsForValue().set("R", "Ram");
        stringRedisTemplate.opsForValue().set("S", "Shyam");
        //Fetch values from set
        System.out.println(stringRedisTemplate.opsForValue().get("R"));
        System.out.println(stringRedisTemplate.opsForValue().get("S"));
        //Using Hash Operation
        String mohan = "Mohan";
        stringRedisTemplate.opsForHash().put("M", String.valueOf(mohan.hashCode()), mohan);
        System.out.println(stringRedisTemplate.opsForHash().get("M", String.valueOf(mohan.hashCode())));
    }
}
