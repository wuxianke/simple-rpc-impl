package com.wu.test;

import com.wu.rpc.api.HelloService;
import com.wu.rpc.registry.DefaultServiceRegistry;
import com.wu.rpc.registry.ServiceRegistry;
import com.wu.rpc.server.RpcServer;

/**
 * 测试接口
 * @author Cactus
 */
public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        rpcServer.start(9000);
    }

}
