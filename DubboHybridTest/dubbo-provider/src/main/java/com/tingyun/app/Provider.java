package com.tingyun.app;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.tingyun.entity.Emp;
import com.tingyun.service.ActiveMQ.ActiveMQComsumerService;
import com.tingyun.service.ActiveMQ.ActiveMQProducterService;
import com.tingyun.service.RabbitMQ.RabbitMQCustomerService;
import com.tingyun.service.RabbitMQ.RabbitMQProducerService;
import com.tingyun.service.imp.*;
import com.tingyun.service.nosql.MemcachedService;
import com.tingyun.service.nosql.MongoDBService;
import com.tingyun.service.nosql.RedisService;
import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import org.bson.Document;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Future;

public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getDisplayName() + ": here");
        context.start();
        System.out.println("服务已经启动...");

        System.in.read();
    }

}
