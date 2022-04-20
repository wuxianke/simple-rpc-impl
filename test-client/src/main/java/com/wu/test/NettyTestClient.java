package com.wu.test;

import com.wu.rpc.api.ByeService;
import com.wu.rpc.api.HelloObject;
import com.wu.rpc.api.HelloService;
import com.wu.rpc.transport.RpcClientProxy;
import com.wu.rpc.transport.netty.client.NettyClient;
import com.wu.rpc.serializer.ProtobufSerializer;

/**
 * 测试用消费者
 * @author Cactus
 */
public class NettyTestClient {
    public static void main(String[] args) {
        NettyClient nettyClient = new NettyClient();
        RpcClientProxy rpcClientProxy = new RpcClientProxy(nettyClient);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        Object res = helloService.hello(object);
        System.out.println(res);
        ByeService byeService = rpcClientProxy.getProxy(ByeService.class);
        System.out.println(byeService.bye("Netty"));
    }
}
