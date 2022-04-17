package com.wu.test;

import com.wu.rpc.api.HelloService;
import com.wu.rpc.provider.ServiceProviderImpl;
import com.wu.rpc.registry.ServiceRegistry;
import com.wu.rpc.serializer.ProtobufSerializer;
import com.wu.rpc.transport.socket.server.SocketServer;

/**
 * 测试接口
 * @author Cactus
 */
public class SocketTestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketServer socketServer = new SocketServer("127.0.0.1", 9998);
        socketServer.setSerializer(new ProtobufSerializer());
        socketServer.publishService(helloService, HelloService.class);
    }

}
