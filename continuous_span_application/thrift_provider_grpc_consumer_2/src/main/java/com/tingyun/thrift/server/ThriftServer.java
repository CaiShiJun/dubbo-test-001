package com.tingyun.thrift.server;

import com.tingyun.thrift.service.QueryImp;
import com.tingyun.thrift.service.TestQry;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftServer {

  private final static int DEFAULT_PORT = 30001;
  private static TServer server = null;
  public static void startThriftServer(){
    try {
      TNonblockingServerSocket socket = new TNonblockingServerSocket(DEFAULT_PORT);
      TestQry.Processor processor = new TestQry.Processor(new QueryImp());
      TNonblockingServer.Args arg = new TNonblockingServer.Args(socket);
      arg.protocolFactory(new TBinaryProtocol.Factory());
      arg.transportFactory(new TFramedTransport.Factory());
      arg.processorFactory(new TProcessorFactory(processor));
      server = new TNonblockingServer (arg);
      server.serve();
    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }
}