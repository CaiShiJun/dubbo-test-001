package com.tingyun.controller;

import com.tingyun.service.ActiveMQ.ActiveMQComsumerService;
import com.tingyun.service.ActiveMQ.ActiveMQProducterService;
import com.tingyun.service.imp.ActiveMQComsumerServiceImpl;
import com.tingyun.service.imp.ActiveMQProducterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActiveMQController {

    @Autowired
    private ActiveMQProducterService activeMQProducterService;

    @Autowired
    private ActiveMQComsumerService activeMQComsumerService;

    @RequestMapping("/activeTest")
    @ResponseBody
    public String activeTest(){

        List sendMessages = new ArrayList();
        sendMessages.add("message"+1);
        sendMessages.add("message"+2);
        sendMessages.add("message"+3);
        sendMessages.add("message"+4);
        sendMessages.add("message"+5);
        activeMQProducterService.sendMessage("caitest",sendMessages);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        activeMQComsumerService.getMessage("caitest");

        return "activeTest"+"success";
    }


}
