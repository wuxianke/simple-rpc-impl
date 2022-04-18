package com.wu.test;

import com.wu.rpc.api.HelloService;
import com.wu.rpc.transport.netty.server.NettyServer;
import com.wu.rpc.serializer.ProtobufSerializer;

/**
 * 测试用Netty服务提供者（服务端）
 * @author Cactus
 */
public class NettyTestServer {

    public static void main(String[] args) {
        NettyHelloServiceImpl helloService = new NettyHelloServiceImpl();
        NettyServer nettyServer = new NettyServer("127.0.0.1", 9999);
        nettyServer.publishService(helloService, HelloService.class);
    }
}
