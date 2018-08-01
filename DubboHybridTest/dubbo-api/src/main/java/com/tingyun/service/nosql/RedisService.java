package com.tingyun.service.nosql;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public interface RedisService {

    public String set(String key,String value);
    public String get(String key);
    public long leftPush(String key,String...strings);
    public long rightPush(String key,String...strings);
    public List lrange(String key, long start , long end);
    public Set<String> keys(String pattern);
    public String leftPop(String key);
    public String rightPop(String key);
    public long delete(String...keys);

    public Jedis getJedis();


}


