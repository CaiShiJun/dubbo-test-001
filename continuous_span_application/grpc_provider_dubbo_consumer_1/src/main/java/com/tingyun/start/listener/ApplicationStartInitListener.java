package com.tingyun.start.listener;

import com.tingyun.grpc.provider.server.HelloWorldServer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationStartInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //启动 GRPC Server
        HelloWorldServer.grpcServerStart();
        System.out.println("=================启动 GRPC Server 成功====================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
