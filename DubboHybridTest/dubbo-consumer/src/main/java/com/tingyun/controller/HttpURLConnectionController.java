package com.tingyun.controller;

import com.tingyun.service.httpURLConnection.HttpURLConnectionService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HttpURLConnectionController {

    @Reference
    private HttpURLConnectionService httpURLConnectionService;

    @RequestMapping("/httpURLConnectionTest")
    @ResponseBody
    public String httpURLConnectionTest(HttpServletRequest request){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        httpURLConnectionService = context.getBean(HttpURLConnectionService.class);

        //HttpURLConnection
        for(int i = 0;i<5;i++) {
            String str = (String) httpURLConnectionService.HttpURLGETConnection("http://localhost:9090/getRandomStr").get("responseMessage");
            ;
            String num = (String) httpURLConnectionService.HttpURLGETConnection("http://localhost:9090/getRandomInt").get("responseMessage");

            System.out.println("Str：" + str);
            System.out.println("Num：" + num);

        }

        return "httpURLConnectionTest"+"success";
    }

}
