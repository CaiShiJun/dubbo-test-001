package org.github.module;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;

import java.io.IOException;

public class RedisRegistryUtil {

    public static void registry(){
        RegistryFactory factory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = factory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
        //注册服务
        registry.register(URL.valueOf("redis://192.168.1.33/org.github.api.DubboDefaultTestService?category=provid" +
                "ers&dynamic=false&application=provider-redis&group=member&loadbalance=consistenthash));"));
        //
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
