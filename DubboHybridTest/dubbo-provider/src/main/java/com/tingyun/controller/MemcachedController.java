package com.tingyun.controller;

import com.tingyun.service.nosql.MemcachedService;
import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;
import java.util.concurrent.Future;

@Controller
public class MemcachedController {

    @Autowired
    private MemcachedService memcachedService;

    @RequestMapping("/memcachedTest")
    @ResponseBody
    public String memcachedTest(){

        UUID uuid = UUID.randomUUID();
        String key = uuid.toString();

        // 存储数据
        Future future = memcachedService.set(key,100,key+"value");

        // 查看存储状态
        Object saveStatus = memcachedService.getStatus(future);
        System.out.println(saveStatus);

        // 查询数据
        Object searchResult = memcachedService.get(key);
        System.out.println(searchResult);

        // 添加
        Future addResult = memcachedService.add(key,100,key+"value");
        System.out.println(addResult);

        // 添加新的 key
        Future replaceResult = memcachedService.replace(key,100,key+"value");
        System.out.println(replaceResult);

        // 对存在的key进行数据添加操作
        Future appendResult = memcachedService.append(key,"dasdfasdfasd");
        System.out.println(appendResult);

        // 对存在的key进行数据添加操作
        Future prependResult = memcachedService.prepend(key,"dasdfasdfasd");
        System.out.println(prependResult);

        // 通过 gets 方法获取 CAS token（令牌）
        CASValue casValue = memcachedService.getsCASValue(key);
        System.out.println(casValue);

        // 尝试使用cas方法来更新数据
        CASResponse casResponse = memcachedService.updateByCAS(key,casValue,200,"1");
        System.out.println(casResponse);

        // 自增
        for (int i = 0;i<5;i++){
            long incrNum = memcachedService.incr(key,2);
            System.out.println(incrNum);
        }

        // 自减
        for (int i = 0;i<5;i++){
            long decrNum = memcachedService.decr(key,2);
            System.out.println(decrNum);
        }

        // 对存在的key进行数据删除操作
        Future deleteResult = memcachedService.delete(key);
        System.out.println(deleteResult);

        //关闭连接
        //memcachedService.shutdown();

        return "memcachedTest"+"success";
    }




}
