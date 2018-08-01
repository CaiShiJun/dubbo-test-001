package com.tingyun.service.nosql;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;

import java.util.concurrent.Future;

public interface MemcachedService {
    public Future set(String key,int exp,Object value);
    public Object getStatus(Future future);
    public Object get(String key);
    public void shutdown();
    public Future add(String key,int exp,Object value);
    public Future replace(String key,int exp,Object value);
    public Future append(String key,Object value);
    public Future prepend(String key,Object value);
    public CASValue getsCASValue(String key);
    public CASResponse updateByCAS(String key, CASValue casValue, int exp, Object value);
    public Future delete(String key);
    public long incr(String key,int by);
    public long decr(String key,int by);
}
