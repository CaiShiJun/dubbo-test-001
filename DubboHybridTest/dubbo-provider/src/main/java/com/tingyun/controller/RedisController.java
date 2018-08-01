package com.tingyun.controller;

import com.tingyun.service.imp.RedisServiceImpl;
import com.tingyun.service.nosql.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Controller
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/redisTest")
    @ResponseBody
    public String redisTest(){

        UUID uuid = UUID.randomUUID();
        String key = uuid.toString();

        Jedis jedis= ((RedisServiceImpl) redisService).getJedis();


        //设置key-value
        String setResult = redisService.set(key,"value"+key);
        System.out.println(setResult);

        //根据 key 获取值
        String getResult = redisService.get(key);
        System.out.println(getResult);

        //从左面添加数据
/*        long leftPushResult = redisService.leftPush(key,"value"+key,"value"+key,"value"+key);
        System.out.println(leftPushResult);*/

        //从右侧添加数据
/*        long rightPushResult = redisService.rightPush(key,"value"+key+4,"value"+key+5,"value"+key+6);
        System.out.println(rightPushResult);*/

        //获取从左数start到end的数据
/*        List lrangeResult = redisService.lrange(key,0,3);
        System.out.println(lrangeResult);*/

        // 获取key
        Set<String> keysResult = redisService.keys("*");
        System.out.println(keysResult);

        //从左面获取数据，并删除该数据
/*        String leftPopResult = redisService.leftPop(key);
        System.out.println(leftPopResult);*/

        //从右侧获取数据，并删除该数据
/*        String rightPopResult = redisService.rightPop(key);
        System.out.println(rightPopResult);*/

        //根据key删除数据
        long deleteResult = redisService.delete(key);
        System.out.println(deleteResult);

        //进行redis的相关操作

        String status=jedis.set("java","spring");
        status=jedis.get("java");
        Map<String,String> map=new HashMap<String,String>();
        map.put("python","java");
        long time=jedis.append("java","hadoop");
        time=jedis.decr("key");
        time=jedis.del("java");
        jedis.incr("java");
        jedis.exists("java");
        jedis.ping();
        byte[] bytes=new byte[]{'a','c'};
        jedis.sort(bytes);
        jedis.keys(bytes);
        jedis.watch(bytes);
        jedis.zcard(bytes);
        jedis.echo("hadoop");
        jedis.expire("hadoop",1);
        jedis.flushAll();
        jedis.hkeys("hadoop");
        jedis.spop("hadoop");
        jedis.hvals("hadoop");
        jedis.sinter("hadoop","java");
        jedis.zrank("hadoop", String.valueOf(23));
        jedis.set("python","spring");
        jedis.renamenx("python","java1");

        return "redisTest"+"success";
    }


}
