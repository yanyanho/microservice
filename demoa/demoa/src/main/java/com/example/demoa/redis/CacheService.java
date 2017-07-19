package com.example.demoa.redis;

import java.util.List;

/**
 * Created by yanyanho on 2017/7/16.
 */
public interface CacheService {
    public void addMessage(String user,String message);
    public List<String> listMessages(String user);
}

