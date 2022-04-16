package com.wu.test;

import com.wu.rpc.api.HelloService;
import com.wu.rpc.registry.DefaultServiceRegistry;
import com.wu.rpc.registry.ServiceRegistry;
import com.wu.rpc.serializer.ProtobufSerializer;
import com.wu.rpc.server.RpcServer;
import com.wu.rpc.socket.server.SocketServer;

import java.net.Socket;

/**
 * 测试接口
 * @author Cactus
 */
public class SocketTestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        SocketServer socketServer = new SocketServer(serviceRegistry);
        socketServer.setSerializer(new ProtobufSerializer());
        socketServer.start(9999);
    }

}
