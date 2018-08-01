package com.tingyun.controller;

import com.tingyun.dubbo.service.DubboProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dubboConsumerController")
public class DubboConsumerController {

    @RequestMapping("/returnLinkedAppNames")
    @ResponseBody
    public String returnLinkedAppNames(){

        //这里可以放置具体业务处理代码 start
        //调用 Dubbo 服务。
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
        context.start();
        DubboProviderService dubboProviderService=(DubboProviderService) context.getBean("demoProviderService");
        String result=dubboProviderService.dubboProviderReturnStrMethod("--dubbo_consumer_1--");
        System.out.println("远程调用结果："+result);

        return result;
    }

}
