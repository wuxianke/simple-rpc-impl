package com.wu.rpc.transport;

import com.wu.rpc.serializer.CommonSerializer;

/**
 * 服务端通用接口
 * @author Cactus
 */
public interface RpcServer {

    void start();

    void setSerializer(CommonSerializer serializer);

    <T> void publishService(T service, Class<T> serviceClass);
}
