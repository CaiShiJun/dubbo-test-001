package com.tingyun.thrift.client;

import com.tingyun.thrift.service.QryResult;
import com.tingyun.thrift.service.TestQry;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClientDemo {
      private final static int DEFAULT_QRY_CODE = 1;
      public static QryResult thriftClientRun(){
            QryResult result = null;
            try {
                  TTransport tTransport = getTTransport();
                  TProtocol protocol = new TBinaryProtocol(tTransport);
                  TestQry.Client client = new TestQry.Client(protocol);
                  result = client.qryTest(DEFAULT_QRY_CODE);
                  System.out.println("code="+result.code+" msg="+result.msg);
            }catch (Exception e) {
                  e.printStackTrace();
            }
            return result;
      }
      private static TTransport getTTransport() throws Exception{
            try{
                  TTransport tTransport = getTTransport("192.168.5.50", 30001, 5000);
                  if(!tTransport.isOpen()){
                        tTransport.open();
                  }
                  return tTransport;
            }catch(Exception e){
                  e.printStackTrace();
            }
            return null;
      }
      private static TTransport getTTransport(String host, int port, int timeout) {
            final TSocket tSocket = new TSocket(host, port, timeout);
            final TTransport transport = new TFramedTransport(tSocket);
            return transport;
      }
}
