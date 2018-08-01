package com.tingyun.service.imp;

import com.tingyun.service.nosql.RedisService;
import com.tingyun.util.ConnectionUtil;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class RedisServiceImpl implements RedisService {

    private Jedis jedis;

    public RedisServiceImpl(){
        jedis = ConnectionUtil.getJedis();
    }

    //设置key-value
    public String set(String key,String value){
        return jedis.set(key,value);
    }

    //根据 key 获取值
    public String get(String key){
        return jedis.get(key);
    }

    //从左面添加数据
    public long leftPush(String key,String...strings){
        return jedis.lpush(key,strings);
    }

    //从右侧添加数据
    public long rightPush(String key,String...strings){
        return jedis.rpush(key,strings);
    }

    //获取从左数start到end的数据
    public List lrange(String key, long start , long end){
        return jedis.lrange(key,start,end);
    }

    // 获取key
    public Set<String> keys(String pattern){
        return jedis.keys(pattern);
    }

    //从左面获取数据，并删除该数据
    public String leftPop(String key){
        return jedis.lpop(key);
    }

    //从右侧获取数据，并删除该数据
    public String rightPop(String key){
        return jedis.lpop(key);
    }

    //根据key删除数据
    public long delete(String...keys){
        return jedis.del(keys);
    }

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }
}
