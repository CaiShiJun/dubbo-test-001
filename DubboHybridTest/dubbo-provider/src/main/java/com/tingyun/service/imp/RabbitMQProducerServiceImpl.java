package com.tingyun.service.imp;

import com.tingyun.service.RabbitMQ.RabbitMQProducerService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {

    public final static String HOST = "39.106.215.103";
    public final static String QUEUE_NAME="rabbitMQ.test";

    @Override
    public void basicPublish(String message) {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost(HOST);
        //创建一个新的连接
        Connection connection = null;
        try {
            connection = factory.newConnection();
            //创建一个通道
            Channel channel = connection.createChannel();
            //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //发送消息到队列中
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");
            //关闭通道和连接
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
