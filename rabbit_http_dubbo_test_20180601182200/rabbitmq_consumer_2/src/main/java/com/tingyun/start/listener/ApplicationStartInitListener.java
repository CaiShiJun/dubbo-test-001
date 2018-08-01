package com.tingyun.start.listener;

import com.rabbitmq.client.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class ApplicationStartInitListener implements ServletContextListener {

    public final static String HOST = "39.106.215.103";
    private final static String QUEUE_NAME = "rabbitMQ.test";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {
            // 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ地址
            factory.setHost(HOST);
            //创建一个新的连接
            Connection connection = factory.newConnection();
            //创建一个通道
            Channel channel = connection.createChannel();
            //声明要关注的队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("Customer Waiting Received messages");
            //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
            // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, com.rabbitmq.client.Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Customer Received '" + message + "'");

                    String url = "http://localhost:20002/dubboConsumerController/returnLinkedAppNames";
                    CloseableHttpClient httpCilent = HttpClients.createDefault();
                    HttpGet httpGet = new HttpGet("http://localhost:20002/dubboConsumerController/returnLinkedAppNames");
                    String reuslt = null;
                    try {
                        HttpResponse httpResponse = httpCilent.execute(httpGet);
                        reuslt = EntityUtils.toString(httpResponse.getEntity())+"--rabbitmq_consumer_2----"+message+"--";
                        System.out.println(reuslt);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            httpCilent.close();//释放资源
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            //GetResponse result = channel.basicGet(QUEUE_NAME, true);
            //System.out.println(result);
            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
