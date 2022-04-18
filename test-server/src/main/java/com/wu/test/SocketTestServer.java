package com.wu.test;

import com.wu.rpc.api.HelloService;
import com.wu.rpc.serializer.ProtobufSerializer;
import com.wu.rpc.transport.socket.server.SocketServer;

/**
 * 测试接口
 * @author Cactus
 */
public class SocketTestServer {
    public static void main(String[] args) {
        HelloService helloService = new SocketHelloServiceImpl();
        SocketServer socketServer = new SocketServer("127.0.0.1", 9998);
        socketServer.publishService(helloService, HelloService.class);
    }

}
