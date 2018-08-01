package com.tingyun.grpc.provider.server;

import com.tingyun.dubbo.service.DubboProviderService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class HelloWorldServer {

    private int port = 50051;
    private Server server;

    /**
     * 启动服务
     * @throws IOException
     */
    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();

        System.out.println("service start...");

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWorldServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // block 一直到退出程序
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    public static void grpcServerStart(){
        final HelloWorldServer server = new HelloWorldServer();
        try {
            server.start();
            server.blockUntilShutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 实现 定义一个实现服务接口的类
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            //获取参数
            System.out.println("收到的信息:"+req.getName());

            //这里可以放置具体业务处理代码 start
            //调用 Dubbo 服务。
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
            context.start();
            DubboProviderService dubboProviderService=(DubboProviderService) context.getBean("demoProviderService");
            String result=dubboProviderService.dubboProviderReturnStrMethod(req.getName());

            System.out.println("远程调用结果："+result);

            //这里可以放置具体业务处理代码 end

            //构造返回
            HelloReply reply = HelloReply.newBuilder().setMessage(result+"---grpc_provider_dubbo_consumer_1").build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}