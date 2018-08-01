package com.tingyun.start.listener;

import com.tingyun.thrift.server.ThriftServer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationStartInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //启动 Thrift Server 。
        ThriftServer.startThriftServer();
        System.out.println("=================启动 Thrift Server 成功====================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
