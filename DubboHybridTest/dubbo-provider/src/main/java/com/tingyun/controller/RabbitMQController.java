package com.tingyun.controller;

import com.tingyun.service.RabbitMQ.RabbitMQCustomerService;
import com.tingyun.service.RabbitMQ.RabbitMQProducerService;
import com.tingyun.service.imp.RabbitMQCustomerServiceImpl;
import com.tingyun.service.imp.RabbitMQProducerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RabbitMQController {

    @Autowired
    private RabbitMQProducerService rabbitMQProducerService;

    @Autowired
    private RabbitMQCustomerService rabbitMQCustomerService;

    @RequestMapping("/rabbitMQTest")
    @ResponseBody
    public String rabbitMQTest(){

        rabbitMQProducerService.basicPublish("dafsdfsa");

        rabbitMQCustomerService.handleDelivery();

        return "rabbitMQTest"+"success";
    }










}
