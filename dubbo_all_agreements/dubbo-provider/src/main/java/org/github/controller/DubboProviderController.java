package org.github.controller;

import org.github.module.MemcachedRegistryUtil;
import org.github.module.RedisRegistryUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/DubboProviderController")
public class DubboProviderController {

    private ClassPathXmlApplicationContext context;

    @RequestMapping("/dubboDefaultProviderMethod")
    @ResponseBody
    public String dubboDefaultProviderMethod(String agreements){

        switch (agreements) {
            case "dubbo-redis-provider":
                RedisRegistryUtil.registry();
                break;
            case "dubbo-memcached-provider":
                MemcachedRegistryUtil.registry();
                break;
            default:
                if(context != null){
                    System.out.println("正在停止dubbo context");
                    context.close();
                }

                synchronized(this){
                    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{agreements+".xml"});
                    System.out.println("正在启动dubbo context");
                    context.start();
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
        return "success:"+agreements;
    }

}
