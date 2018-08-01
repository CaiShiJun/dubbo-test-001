package com.tingyun.controller;

import com.tingyun.service.httpURLConnection.HttpURLConnectionService;
import com.tingyun.service.httpclient.HttpClientService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpClientController {

    @Reference
    private HttpClientService httpClientService;

    @RequestMapping("/httpClientTest")
    @ResponseBody
    public String httpClientTest(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        httpClientService = context.getBean(HttpClientService.class);

        //HttpClient
        for(int i = 0;i<5;i++) {
            String str = httpClientService.httpClientGet("http://localhost:9090/getRandomStr");
            ;
            String num = httpClientService.httpClientGet("http://localhost:9090/getRandomInt");

            System.out.println("Str：" + str);
            System.out.println("Num：" + num);

        }

        return "httpClientTest"+"success";
    }


}
