package com.wu.test;

import com.wu.rpc.api.HelloService;
import com.wu.rpc.server.RpcServer;

/**
 * 测试接口
 * @author Cactus
 */
public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }

}
