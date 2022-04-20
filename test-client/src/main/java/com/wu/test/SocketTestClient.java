package com.wu.test;

import com.wu.rpc.api.ByeService;
import com.wu.rpc.api.HelloObject;
import com.wu.rpc.api.HelloService;
import com.wu.rpc.loadbalancer.RoundRobinLoadBalancer;
import com.wu.rpc.transport.RpcClientProxy;
import com.wu.rpc.serializer.ProtobufSerializer;
import com.wu.rpc.transport.socket.client.SocketClient;

/**
 * 客户端测试
 *
 * @author Cactus
 */
public class SocketTestClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient(new RoundRobinLoadBalancer());
        //接口与代理对象之间的中介对象
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject obj = new HelloObject(12, "This is a message");
//        for (int i = 0; i < 20; i++) {
//            Object res = helloService.hello(obj);
//            System.out.println(res);
//        }
        Object res = helloService.hello(obj);
        System.out.println(res);
        ByeService byeService = proxy.getProxy(ByeService.class);
        System.out.println(byeService.bye("Socket"));
    }
}
