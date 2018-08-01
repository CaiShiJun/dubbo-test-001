package com.tingyun.service.RabbitMQ;

public interface RabbitMQProducerService {

    //发送消息到队列中
    public void basicPublish(String message);

}
