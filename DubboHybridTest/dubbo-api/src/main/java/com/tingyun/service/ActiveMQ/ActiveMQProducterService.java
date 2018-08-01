package com.tingyun.service.ActiveMQ;

import java.util.List;

public interface ActiveMQProducterService {

    //发送消息
    public void sendMessage(String disname, List<String> messages);

}
