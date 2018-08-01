package com.tingyun.service.imp;

import com.mongodb.MongoClient;
import com.tingyun.service.nosql.MemcachedService;
import com.tingyun.util.ConnectionUtil;
import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MemcachedServiceImpl implements MemcachedService {

    private MemcachedClient memcachedClient;

    public MemcachedServiceImpl(){
        memcachedClient = ConnectionUtil.getMemcachedClient();
    }

    // 存储数据
    public Future set(String key,int exp,Object value){
       return memcachedClient.set(key, exp, value);
    }

    // 查看存储状态
    public Object getStatus(Future future){
        Object result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 查询数据
    public Object get(String key){
        return memcachedClient.get(key);
    }

    //关闭连接
    public void shutdown(){
        memcachedClient.shutdown();
    }

    // 添加
    public Future add(String key,int exp,Object value){
        return memcachedClient.add(key, exp, value);
    }

    // 添加新的 key
    public Future replace(String key,int exp,Object value){
        return memcachedClient.replace(key, exp, value);
    }

    // 对存在的key进行数据添加操作
    public Future append(String key,Object value){
        return memcachedClient.append(key,value);
    }

    // 对存在的key进行数据添加操作
    public Future prepend(String key,Object value){
        return memcachedClient.prepend(key,value);
    }

    // 通过 gets 方法获取 CAS token（令牌）
    public CASValue getsCASValue(String key){
        return memcachedClient.gets(key);
    }

    // 尝试使用cas方法来更新数据
    public CASResponse updateByCAS(String key,CASValue casValue,int exp,Object value){
        return memcachedClient.cas(key,casValue.getCas(),exp,value);
    }

    // 对存在的key进行数据删除操作
    public Future delete(String key){
        return memcachedClient.delete(key);
    }

    // 自增
    public long incr(String key,int by){
        return memcachedClient.incr(key,by);
    }

    // 自减
    public long decr(String key,int by){
        return memcachedClient.decr(key,by);
    }

}
