package com.wu.test;

import com.wu.rpc.api.HelloObject;
import com.wu.rpc.api.HelloService;
import com.wu.rpc.client.RpcClientProxy;
import com.wu.rpc.socket.client.SocketClient;

/**
 * 客户端测试
 * @author Cactus
 */
public class SocketTestClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient("127.0.0.1", 9000);
        //接口与代理对象之间的中介对象
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject obj = new HelloObject(12, "This is a message");
        Object res = helloService.hello(obj);
        System.out.println(res);
    }
}