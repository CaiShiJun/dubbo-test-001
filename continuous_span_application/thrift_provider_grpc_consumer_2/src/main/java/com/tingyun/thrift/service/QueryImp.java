package com.tingyun.thrift.service;

import com.tingyun.grpc.client.HelloWorldGrpcClient;
import org.apache.thrift.TException;

public class QueryImp implements TestQry.Iface {
    @Override
    public QryResult qryTest(int qryCode) throws TException {
        QryResult result = new QryResult();
        if (qryCode == 1) {
            HelloWorldGrpcClient client = new HelloWorldGrpcClient("127.0.0.1",50051);
            try {
                result.msg = client.greet("---thrift_provider_grpc_consumer_2---httpclient_provider_thrift_consumer_3");
            }finally {
                try {
                    client.shutdown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } else {
            result.code = 0;
            result.msg = "fail";
        }
        return result;
    }
}