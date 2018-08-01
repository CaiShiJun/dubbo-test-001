package com.tingyun.service.imp;

import com.tingyun.service.ActiveMQ.ActiveMQComsumerService;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ActiveMQComsumerServiceImpl implements ActiveMQComsumerService {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String BROKEN_URL = "tcp://39.106.215.103:61616";

    ConnectionFactory connectionFactory;

    Connection connection;

    Session session;

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();
    AtomicInteger count = new AtomicInteger();

    public ActiveMQComsumerServiceImpl(){
        try {
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEN_URL);
            connection  = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getMessage(String disname) {
        try {
            Queue queue = session.createQueue(disname);
            MessageConsumer consumer = null;

            if(threadLocal.get()!=null){
                consumer = threadLocal.get();
            }else{
                consumer = session.createConsumer(queue);
                threadLocal.set(consumer);
            }
            for(int i = 0;i<5;i++) {
                Thread.sleep(1000);
                TextMessage msg = (TextMessage) consumer.receive();
                msg.acknowledge();
                System.out.println(Thread.currentThread().getName() + ": Consumer:我是消费者，我正在消费Msg" + msg.getText() + "--->" + count.getAndIncrement());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
