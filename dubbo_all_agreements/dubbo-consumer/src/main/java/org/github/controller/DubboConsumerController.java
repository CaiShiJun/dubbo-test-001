package org.github.controller;

import org.github.api.DubboDefaultTestService;
import org.github.api.DubboThriftTestService;
import org.github.callback.CallbackListener;
import org.github.callback.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/DubboConsumerController")
public class DubboConsumerController {

    private ClassPathXmlApplicationContext context;

    @RequestMapping("/dubboDefaultConsumerMethod")
    @ResponseBody
    public String dubboDefaultConsumerMethod(String agreements)throws Exception{
        if(context != null){
            System.out.println("正在停止dubbo context");
            context.close();
        }

        String resultStr = null;
        int resultInt = 0;

        synchronized(this) {
            //这里可以放置具体业务处理代码 start
            //调用 Dubbo 服务。
            context = new ClassPathXmlApplicationContext(new String[]{agreements + ".xml"});
            System.out.println("正在启动dubbo context");
            context.start();

            if (agreements.equals("dubbo-memcached-consumer") || agreements.equals("dubbo-redis-consumer")) {
                // Memcached和Redis
                DubboDefaultTestService dubboDefaultTestService = (DubboDefaultTestService) context.getBean("dubboDefaultTestService");
                dubboDefaultTestService.setString("key1", "value1" + agreements);
                resultStr = dubboDefaultTestService.getString("key1");
            } else if (agreements.equals("dubbo-thrift-consumer")) {
                //Thrift
                DubboThriftTestService.Iface dubboThriftTestService = (DubboThriftTestService.Iface) context.getBean("dubboThriftTestService");
                resultStr = dubboThriftTestService.getString();
                resultInt = dubboThriftTestService.getInt();
            } else if (agreements.equals("dubbo-callback-consumer")){
                CallbackService callbackService = (CallbackService) context.getBean("callbackService");
                callbackService.addListener("foo.bar", new CallbackListener() {
                    public void changed(String msg) {
                        System.out.println("callback1:" + msg);
                    }
                });
            }else{
                //默认通用
                DubboDefaultTestService dubboDefaultTestService = (DubboDefaultTestService) context.getBean("dubboDefaultTestService");
                resultStr = dubboDefaultTestService.getString();
                resultInt = dubboDefaultTestService.getInt();
            }
        }

        Thread.sleep(3000);

        return agreements+"      resultStr:"+resultStr+"      resultInt:"+resultInt;
    }



}
