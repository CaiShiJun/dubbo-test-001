package com.tingyun.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import net.spy.memcached.MemcachedClient;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUtil {

    private static MongoClient mongoClient;
    private static MemcachedClient memcachedClient;
    private static Jedis jedis;


    // 连接到 mongodb 服务
    public static MongoClient getMongoClient(){
        if(mongoClient==null) {

            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("39.106.215.103",27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("caitest", "mycol", "caitest".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
            mongoClient = new MongoClient(addrs,credentials);

        }

        // 连接到数据库
        //MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
        System.out.println("Connect to database successfully");
        return mongoClient;
    }

    //本地连接 Memcached 服务
    public static MemcachedClient getMemcachedClient(){
        if(memcachedClient==null){
            try {
                memcachedClient = new MemcachedClient(new InetSocketAddress("39.106.215.103", 11211));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Connection to server sucessful.");
        return memcachedClient;
    }

    //连接本地的 Redis 服务
    public static Jedis getJedis(){
        if (jedis==null){
            jedis = new Jedis("39.106.215.103");
            jedis.auth("Redis!123");
        }
        System.out.println("连接成功");
        return jedis;
    }

}
