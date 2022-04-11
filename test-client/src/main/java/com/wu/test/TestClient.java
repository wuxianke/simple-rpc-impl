package com.wu.test;

import com.wu.rpc.api.HelloObject;
import com.wu.rpc.api.HelloService;
import com.wu.rpc.client.RpcClientProxy;

/**
 * 客户端测试
 * @author Cactus
 */
public class TestClient {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject obj = new HelloObject(12, "This is a message");
        String res = helloService.hello(obj);
        System.out.println(res);
    }
}
