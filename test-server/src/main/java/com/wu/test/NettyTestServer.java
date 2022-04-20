package com.wu.test;

import com.wu.rpc.annotation.ServiceScan;
import com.wu.rpc.api.HelloService;
import com.wu.rpc.serializer.CommonSerializer;
import com.wu.rpc.transport.netty.server.NettyServer;
import com.wu.rpc.serializer.ProtobufSerializer;
import com.wu.rpc.transport.socket.server.SocketServer;

/**
 * 测试用Netty服务提供者（服务端）
 * @author Cactus
 */
@ServiceScan
public class NettyTestServer {

    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        socketServer.start();
    }
}
